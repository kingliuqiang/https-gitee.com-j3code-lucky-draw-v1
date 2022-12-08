package cn.j3code.luckyapp.mq.consume;

import cn.j3code.config.dto.ActivityDrawMessage;
import com.alibaba.fastjson.JSON;
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
@RocketMQMessageListener(topic = "activity-draw-topic", consumerGroup = "lucky_draw")
public class ActivityDrawMessageConsume implements RocketMQListener<ActivityDrawMessage> {

    @Override
    public void onMessage(ActivityDrawMessage activityDrawMessage) {
        // 扣减库存：mysql
        // 将不可见中奖记录改为可见状态
        log.info("接受到MQ消息了，{}", JSON.toJSONString(activityDrawMessage));
    }
}
