package cn.j3code.luckyapp.listener.event;

import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.listener.event
 * @createTime 2022/12/7 - 22:41
 * @description
 */
@Slf4j
public class ActivityCreateEvent extends ApplicationEvent {

    /**
     * 活动创建id
     */
    private final ActivityConfigVO activityConfigVO;

    public ActivityConfigVO getActivityConfig() {
        return activityConfigVO;
    }

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ActivityCreateEvent(Object source, ActivityConfigVO activityConfigVO) {
        super(source);
        this.activityConfigVO = activityConfigVO;
    }
}
