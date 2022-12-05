package cn.j3code.luckyapp.assembler;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.ActivityRuleAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.assembler
 * @createTime 2022/12/4 - 23:17
 * @description
 */
public class ActivityRuleAssembler {
    public static ActivityRuleEntity toAddEntity(ActivityRuleAddCmd cmd) {
        ActivityRuleEntity activityRuleEntity = new ActivityRuleEntity();
        activityRuleEntity.setActivityId(cmd.getActivityId());
        activityRuleEntity.setRuleId(cmd.getRuleId());
        activityRuleEntity.setCreateTime(LocalDateTime.now());
        activityRuleEntity.setCreator(SecurityUtil.getName());
        activityRuleEntity.setUpdateTime(LocalDateTime.now());
        activityRuleEntity.setUpdater(SecurityUtil.getName());

        return activityRuleEntity;
    }

    public static ActivityRuleVO toActivityRuleVO(ActivityRuleEntity entity) {
        ActivityRuleVO activityRuleVO = new ActivityRuleVO();
        activityRuleVO.setId(entity.getId());
        activityRuleVO.setActivityId(entity.getActivityId());
        activityRuleVO.setRuleId(entity.getRuleId());
        activityRuleVO.setCreateTime(entity.getCreateTime());
        activityRuleVO.setCreator(entity.getCreator());
        activityRuleVO.setUpdateTime(entity.getUpdateTime());
        activityRuleVO.setUpdater(entity.getUpdater());

        return activityRuleVO;
    }
}
