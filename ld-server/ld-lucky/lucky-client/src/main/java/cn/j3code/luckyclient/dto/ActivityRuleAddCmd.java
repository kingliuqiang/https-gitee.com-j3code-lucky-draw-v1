package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/12/4 - 23:04
 * @description
 */
@Data
public class ActivityRuleAddCmd extends Command {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 规则id
     */
    private Long ruleId;
}
