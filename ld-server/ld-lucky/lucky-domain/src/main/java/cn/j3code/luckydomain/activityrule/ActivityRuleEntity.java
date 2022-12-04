package cn.j3code.luckydomain.activityrule;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.activityrule
 * @createTime 2022/12/4 - 23:02
 * @description
 */
@Entity
@Data
public class ActivityRuleEntity {

    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 规则id
     */
    private Long ruleId;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private String creator;

    /**
     *
     */
    private LocalDateTime updateTime;

    /**
     *
     */
    private String updater;

}
