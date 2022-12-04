package cn.j3code.luckyapp.activityrule.command;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.exception.LdException;
import cn.j3code.luckyapp.assembler.ActivityRuleAssembler;
import cn.j3code.luckyclient.dto.ActivityRuleAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;
import cn.j3code.luckydomain.gateway.ActivityRuleGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activityrule.command
 * @createTime 2022/12/4 - 23:14
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleAddCmdExe {

    private final ActivityRuleGateway activityRuleGateway;

    public ActivityRuleVO execute(ActivityRuleAddCmd cmd) {
        ActivityRuleEntity entity = activityRuleGateway.save(ActivityRuleAssembler.toAddEntity(cmd));

        return ActivityRuleAssembler.toActivityRuleVO(entity);
    }

    public List<ActivityRuleVO> execute(List<ActivityRuleAddCmd> cmdList) {
        if (CollectionUtil.isEmpty(cmdList)) {
            throw new LdException("数据有误！");
        }

        List<ActivityRuleVO> result = new ArrayList<>();
        for (ActivityRuleAddCmd addCmd : cmdList) {
            result.add(execute(addCmd));
        }

        return result;
    }
}
