package cn.j3code.luckyapp.service;

import cn.j3code.luckyapp.activityrule.command.ActivityRuleAddCmdExe;
import cn.j3code.luckyapp.activityrule.query.ActivityRuleListByParamQueryExe;
import cn.j3code.luckyclient.api.IActivityRuleService;
import cn.j3code.luckyclient.dto.ActivityRuleAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/4 - 23:13
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class ActivityRuleServiceImpl  implements IActivityRuleService{

    private final ActivityRuleAddCmdExe activityRuleAddCmdExe;
    private final ActivityRuleListByParamQueryExe activityRuleListByParamQueryExe;

    @Override
    public ActivityRuleVO add(ActivityRuleAddCmd cmd) {
        return activityRuleAddCmdExe.execute(cmd);
    }

    @Override
    public List<ActivityRuleVO> list(ActivityRuleListByParamQuery query) {
        return activityRuleListByParamQueryExe.execute(query);
    }
}
