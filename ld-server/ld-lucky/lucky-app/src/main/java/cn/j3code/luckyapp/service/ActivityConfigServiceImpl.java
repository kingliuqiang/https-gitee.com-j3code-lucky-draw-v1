package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.activity.command.ActivityAddCmdExe;
import cn.j3code.luckyapp.activity.command.ActivityUpdateCmdExe;
import cn.j3code.luckyapp.activity.query.ActivityListByParamQueryExe;
import cn.j3code.luckyapp.activityrule.command.ActivityRuleAddCmdExe;
import cn.j3code.luckyapp.activityrule.command.ActivityRuleDeleteExe;
import cn.j3code.luckyapp.activityrule.query.ActivityRuleListByParamQueryExe;
import cn.j3code.luckyapp.award.command.AwardAddCmdExe;
import cn.j3code.luckyapp.award.command.AwardUpdateCmdExe;
import cn.j3code.luckyapp.award.query.AwardListByParamQueryExe;
import cn.j3code.luckyapp.rule.query.RuleListByParamQueryExe;
import cn.j3code.luckyclient.api.IActivityConfigService;
import cn.j3code.luckyclient.dto.*;
import cn.j3code.luckyclient.dto.data.*;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/4 - 22:37
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class ActivityConfigServiceImpl implements IActivityConfigService {

    private final ActivityAddCmdExe activityAddCmdExe;
    private final ActivityRuleAddCmdExe activityRuleAddCmdExe;
    private final AwardAddCmdExe awardAddCmdExe;

    private final ActivityUpdateCmdExe activityUpdateCmdExe;
    private final ActivityRuleDeleteExe activityRuleDeleteExe;
    private final AwardUpdateCmdExe awardUpdateCmdExe;

    private final ActivityListByParamQueryExe activityListByParamQueryExe;
    private final RuleListByParamQueryExe ruleListByParamQueryExe;
    private final ActivityRuleListByParamQueryExe activityRuleListByParamQueryExe;
    private final AwardListByParamQueryExe awardListByParamQueryExe;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ActivityConfigVO add(ActivityConfigAddCmd cmd) {

        ActivityVO activityVO = activityAddCmdExe.execute(cmd.getActivityAddCmd());

        List<RuleVO> ruleVOList = addActivityRule(activityVO, cmd.getRuleIdList());

        List<AwardVO> awardVOList = addAward(activityVO, cmd.getAwardAddCmdList());

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();
        activityConfigVO.setActivityVO(activityVO);
        activityConfigVO.setRuleVOList(ruleVOList);
        activityConfigVO.setAwardVOList(awardVOList);
        return activityConfigVO;
    }

    private List<AwardVO> addAward(ActivityVO activityVO, List<AwardAddCmd> awardAddCmdList) {
        AssertUtil.isTrue(CollectionUtil.isEmpty(awardAddCmdList), "奖项不为空！");

        List<AwardVO> result = new ArrayList<>();
        for (AwardAddCmd awardAddCmd : awardAddCmdList) {
            awardAddCmd.setActivityId(activityVO.getId());
            result.add(awardAddCmdExe.execute(awardAddCmd));
        }

        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ActivityConfigVO update(ActivityConfigUpdateCmd cmd) {
        ActivityVO activityVO = activityUpdateCmdExe.execute(cmd.getActivityUpdateCmd());

        activityRuleDeleteExe.execute(activityVO.getId());
        List<RuleVO> ruleVOList = addActivityRule(activityVO, cmd.getRuleIdList());

        List<AwardVO> awardVOList = updateAward(activityVO, cmd.getAwardUpdateCmdList());

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();
        activityConfigVO.setActivityVO(activityVO);
        activityConfigVO.setRuleVOList(ruleVOList);
        activityConfigVO.setAwardVOList(awardVOList);
        return activityConfigVO;
    }

    private List<AwardVO> updateAward(ActivityVO activityVO, List<AwardUpdateCmd> awardUpdateCmdList) {
        AssertUtil.isTrue(CollectionUtil.isEmpty(awardUpdateCmdList), "奖项不为空！");

        List<AwardVO> result = new ArrayList<>();
        for (AwardUpdateCmd awardUpdateCmd : awardUpdateCmdList) {
            result.add(awardUpdateCmdExe.execute(awardUpdateCmd));
        }

        return result;
    }


    @Override
    public ActivityConfigVO one(Long id) {
        final var activityListByParamQuery = new ActivityListByParamQuery();
        activityListByParamQuery.setId(id);
        List<ActivityVO> activityVOList = activityListByParamQueryExe.execute(activityListByParamQuery).getRecords();
        AssertUtil.isTrue(CollectionUtil.isEmpty(activityVOList), "数据不存在！");

        ActivityVO activityVO = activityVOList.get(0);

        final var activityRuleListByParamQuery = new ActivityRuleListByParamQuery();
        activityRuleListByParamQuery.setActivityId(activityVO.getId());
        List<ActivityRuleVO> activityRuleVOList = activityRuleListByParamQueryExe.execute(activityRuleListByParamQuery);
        List<RuleVO> ruleVOList = getRuleVOList(activityRuleVOList.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));

        AwardListByParamQuery awardListByParamQuery = new AwardListByParamQuery();
        awardListByParamQuery.setActivityId(activityVO.getId());
        awardListByParamQuery.setPageSize(1000);
        List<AwardVO> awardVOList = awardListByParamQueryExe.execute(awardListByParamQuery).getRecords();


        ActivityConfigVO activityConfigVO = new ActivityConfigVO();
        activityConfigVO.setActivityVO(activityVO);
        activityConfigVO.setRuleVOList(ruleVOList);
        activityConfigVO.setAwardVOList(awardVOList);
        return activityConfigVO;
    }


    private List<RuleVO> addActivityRule(ActivityVO activityVO, List<Long> ruleIdList) {

        List<ActivityRuleAddCmd> cmdList = new ArrayList<>();
        for (Long ruleId : ruleIdList) {
            ActivityRuleAddCmd activityRuleAddCmd = new ActivityRuleAddCmd();
            activityRuleAddCmd.setActivityId(activityVO.getId());
            activityRuleAddCmd.setRuleId(ruleId);
            cmdList.add(activityRuleAddCmd);
        }
        List<ActivityRuleVO> activityRuleVOList = activityRuleAddCmdExe.execute(cmdList);

        return getRuleVOList(activityRuleVOList.stream().map(ActivityRuleVO::getRuleId).collect(Collectors.toList()));
    }


    private List<RuleVO> getRuleVOList(List<Long> ruleIdList){
        RuleListByParamQuery query = new RuleListByParamQuery();
        query.setIds(ruleIdList);
        query.setPageSize(1000);

        return ruleListByParamQueryExe.execute(query).getRecords();
    }
}
