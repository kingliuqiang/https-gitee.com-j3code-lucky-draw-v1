package cn.j3code.luckyapp.activityrule.command;

import cn.j3code.luckydomain.gateway.ActivityRuleGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activityrule.command
 * @createTime 2022/12/4 - 23:31
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleDeleteExe {

    private final ActivityRuleGateway activityRuleGateway;

    public void execute(Long activityId) {
        activityRuleGateway.deleteByActivityId(activityId);
    }
}
