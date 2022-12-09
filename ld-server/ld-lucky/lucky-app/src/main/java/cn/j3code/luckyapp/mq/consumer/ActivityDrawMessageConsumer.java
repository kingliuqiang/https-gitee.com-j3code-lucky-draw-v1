package cn.j3code.luckyapp.mq.consumer;

import cn.j3code.config.dto.ActivityDrawMessage;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.activity.command.RedisDeductionAwardNumberDrawExe;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.mq.consume
 * @createTime 2022/12/8 - 23:44
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
@RocketMQMessageListener(topic = "activity-draw-topic", consumerGroup = "lucky_draw")
public class ActivityDrawMessageConsumer implements RocketMQListener<ActivityDrawMessage> {

    private final RedisDeductionAwardNumberDrawExe drawExe;

    @Override
    public void onMessage(ActivityDrawMessage activityDrawMessage) {
        log.info("接受到MQ消息了，{}", JSON.toJSONString(activityDrawMessage));
        String body = activityDrawMessage.getBody();
        ActivityDrawContext context = JSON.parseObject(body, ActivityDrawContext.class);

        if (Boolean.FALSE.equals(drawExe.mqDeductionOfInventoryAndUpdateRecordStatus(context))){
            AssertUtil.isTrue(true, "执行消费MQ逻辑失败（扣减库存和修改不可见记录）");
        }
    }
}
