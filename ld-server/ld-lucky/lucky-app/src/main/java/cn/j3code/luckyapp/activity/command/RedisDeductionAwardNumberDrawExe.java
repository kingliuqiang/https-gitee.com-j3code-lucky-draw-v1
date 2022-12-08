package cn.j3code.luckyapp.activity.command;

import cn.j3code.config.exception.LdException;
import cn.j3code.config.util.FileLoad;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import cn.j3code.luckyapp.listener.AwardInventoryToRedisApplicationListener;
import cn.j3code.luckyapp.mq.product.ActivityDrawMessageProduct;
import cn.j3code.luckydomain.gateway.AwardGateway;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activity.command
 * @createTime 2022/12/7 - 23:18
 * @description
 */
@Slf4j
@Component
public class RedisDeductionAwardNumberDrawExe extends DefaultDrawExe {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ActivityDrawMessageProduct activityDrawMessageProduct;

    private static String stockDeductionLua;
    private static String stockRollbackLua;

    static {
        RedisDeductionAwardNumberDrawExe.stockDeductionLua = FileLoad.read("lua/stock_deduction.lua");
        RedisDeductionAwardNumberDrawExe.stockRollbackLua = FileLoad.read("lua/stock_rollback.lua");
    }


    public RedisDeductionAwardNumberDrawExe(AwardGateway awardGateway,
                                            PrizeGateway prizeGateway,
                                            TransactionTemplate transactionTemplate,
                                            ActivityDrawMessageProduct activityDrawMessageProduct,
                                            RedisTemplate<String, Object> redisTemplate) {
        super(awardGateway, prizeGateway, transactionTemplate);
        this.redisTemplate = redisTemplate;
        this.activityDrawMessageProduct = activityDrawMessageProduct;
    }


    @Override
    protected Boolean drawBefore(ActivityDrawContext context) {
        // 扣减 redis 库存
        Integer deductionLua = invokeStockDeductionLua(AwardInventoryToRedisApplicationListener.getKey(
                context.getAwardEntity().getActivityId(), context.getAwardVO().getId()));

        if (deductionLua != 1) {
            return Boolean.FALSE;
        }

        return super.getTransactionTemplate().execute(status -> {
            Boolean success = Boolean.TRUE;
            try {
                // 插入不可见抽奖记录
                super.addRecord(context);
                // 发送 MQ 消息
                if (Boolean.FALSE.equals(activityDrawMessageProduct.send(context))) {
                    throw new LdException("MQ发送消息失败！");
                }
            } catch (Exception e) {
                //错误处理
                status.setRollbackOnly();
                invokeStockRollbackLua(AwardInventoryToRedisApplicationListener.getKey(
                        context.getAwardEntity().getActivityId(), context.getAwardVO().getId()));
                success = Boolean.FALSE;
                log.error("扣减库存失败或发送MQ消息失败，", e);
            }
            return success;
        });
    }

    public Integer invokeStockDeductionLua(String key) {
        /**
         * stockDeductionLua: lua 脚本
         * Long.class: 返回执行后的库存值类型
         */
        RedisScript<Long> redisScript = new DefaultRedisScript<>(stockDeductionLua, Long.class);

        Long execute = redisTemplate.opsForValue().getOperations().execute(
                redisScript,
                List.of(key));

        if (Objects.isNull(execute) || execute == -1) {
            return 0;
        }

        return 1;
    }


    public Integer invokeStockRollbackLua(String key) {
        /**
         * stockDeductionLua: lua 脚本
         * Long.class: 返回执行后的库存值类型
         */
        RedisScript<Long> redisScript = new DefaultRedisScript<>(stockRollbackLua, Long.class);

        Long execute = redisTemplate.opsForValue().getOperations().execute(
                redisScript,
                List.of(key));

        if (Objects.isNull(execute) || execute < 0) {
            return 0;
        }

        return 1;
    }
}
