package cn.j3code.luckyapp.listener;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyapp.listener.event.ActivityCreateEvent;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.listener
 * @createTime 2022/12/7 - 22:36
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardInventoryToRedisApplicationListener implements ApplicationListener<ActivityCreateEvent> {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * lucky-draw:activity:award:活动id:奖项id
     */
    private static final String awardInventoryKey = "lucky-draw:activity:award:";


    @Override
    public void onApplicationEvent(ActivityCreateEvent event) {
        log.info("ActivityCreateEvent_执行...");
        ActivityConfigVO activityConfig = event.getActivityConfig();
        for (AwardVO awardVO : activityConfig.getAwardVOList()) {
            AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
            if (Boolean.FALSE.equals(awardEntity.isPrize())) {
                continue;
            }
            String key = getKey(activityConfig.getActivityVO().getId(), awardVO.getId());
            redisTemplate.opsForValue().set(key, awardVO.getNumber());

            log.info("ActivityCreateEvent_ActivityId:{}，awardId:{}，存入库存：{} Redis成功...",
                    activityConfig.getActivityVO().getId(),
                    awardVO.getId(),
                    redisTemplate.opsForValue().get(key)
            );
        }
    }

    public static String getKey(Long activityId, Long awardId) {

        return awardInventoryKey + activityId + ":" + awardId;
    }
}
