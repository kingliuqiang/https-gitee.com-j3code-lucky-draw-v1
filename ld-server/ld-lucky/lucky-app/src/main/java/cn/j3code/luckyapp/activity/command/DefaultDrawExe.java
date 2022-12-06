package cn.j3code.luckyapp.activity.command;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.RandomUtil;
import cn.j3code.config.exception.LdException;
import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.data.*;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.activity.ActivityStatusEnum;
import cn.j3code.luckydomain.activity.ActivityTime;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activity.command
 * @createTime 2022/12/7 - 0:03
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class DefaultDrawExe extends BaseDrawExe{

    private final AwardGateway awardGateway;
    private final PrizeGateway prizeGateway;

    @Override
    protected void addAcceptPrize(Long id, AwardEntity awardEntity) {

    }
    @Override
    protected DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList) {
        DrawResultVO result = new DrawResultVO();
        for (AwardVO awardVO : awardVOList) {
            if ("0".equals(awardVO.getPrizeId())) {
                result = getDrawResultVO(AwardAssembler.toAwardEntity(awardVO));
                break;
            }
        }
        return result;
    }

    @Override
    protected int deductionAwardNumber(Long awardId, Integer number) {
        return awardGateway.deductionAwardNumber(awardId, number);
    }

    @Override
    protected DrawResultVO getDrawResultVO(AwardEntity awardEntity) {
        DrawResultVO drawResultVO = new DrawResultVO();
        drawResultVO.setAwardName(awardEntity.getAwardName());
        drawResultVO.setPrizeName(prizeGateway.one(awardEntity.getId()).getPrizeName());
        drawResultVO.setIsDraw(awardEntity.isPrize());
        return drawResultVO;
    }

    @Override
    protected AwardVO getAward(List<AwardVO> awardVOList) {
        // 抽奖算法
        /*
        1、权重
         */
        List<WeightRandom.WeightObj<AwardVO>> weightList = new ArrayList<>();
        awardVOList.forEach(item -> weightList.add(new WeightRandom.WeightObj<>(item, item.getProbability())));
        //创建带有权重的随机生成器
        WeightRandom<AwardVO> wr = RandomUtil.weightRandom(weightList);
        return wr.next();
    }
    @Override
    protected List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList) {
        if (CollectionUtil.isEmpty(awardVOList)) {
            return new ArrayList<>();
        }
        return awardVOList.stream()
                .filter(item -> item.getNumber() > 0 || "0".equals(item.getPrizeId().toString()))
                .collect(Collectors.toList());
    }

    @Override
    protected void checkActivityRule(ActivityConfigVO activityConfigVO) {
        List<RuleVO> ruleVOList = activityConfigVO.getRuleVOList();


    }
    @Override
    protected void checkActivityTime(ActivityVO activityVO) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityTime(new ActivityTime(activityVO.getStartTime(), activityVO.getEndTime()));
        ActivityStatusEnum activityStatus = activityEntity.getActivityTime().getStatus();
        if (!ActivityStatusEnum.START.equals(activityStatus)) {
            throw new LdException(String.format("活动s%", activityStatus.getDescription()));
        }
    }
}
