package cn.j3code.luckyapp.activity.command;

import cn.j3code.config.util.FileLoad;
import cn.j3code.luckyapp.listener.AwardInventoryToRedisApplicationListener;
import cn.j3code.luckydomain.gateway.AwardGateway;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.List;

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

    private static String stockDeductionLua;
    private static String stockRollbackLua;

    static {
        RedisDeductionAwardNumberDrawExe.stockDeductionLua = FileLoad.read("lua/stock_deduction.lua");
        RedisDeductionAwardNumberDrawExe.stockRollbackLua = FileLoad.read("lua/lua_rollback.lua");
    }



    public RedisDeductionAwardNumberDrawExe(AwardGateway awardGateway,
                                            PrizeGateway prizeGateway,
                                            RedisTemplate<String, Object> redisTemplate
    ) {
        super(awardGateway, prizeGateway);
        this.redisTemplate = redisTemplate;
    }


    @Override
    public Integer defaultDeductionAwardNumber(Long activityId, Long awardId ) {
        /**
         * stockDeductionLua: lua 脚本
         * Long.class: 返回执行后的库存值类型
         */
        RedisScript<Long> redisScript = new DefaultRedisScript<>(stockDeductionLua, Long.class);

        Long execute = redisTemplate.opsForValue().getOperations().execute(
                redisScript,
                List.of(AwardInventoryToRedisApplicationListener.getKey(activityId, awardId))
        );

        // execute = -1 表明 库存扣减失败
        if (execute == -1) {
            // 失败
            return 0;
        }
        // 成功

        // 插入不可见记录

        return 1;
    }
}
