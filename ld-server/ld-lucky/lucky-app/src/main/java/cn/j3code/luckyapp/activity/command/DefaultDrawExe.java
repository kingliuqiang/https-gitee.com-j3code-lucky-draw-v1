package cn.j3code.luckyapp.activity.command;

import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.RandomUtil;
import cn.j3code.config.exception.LdException;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import cn.j3code.luckyclient.dto.data.*;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.activity.ActivityStatusEnum;
import cn.j3code.luckydomain.activity.ActivityTime;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activity.command
 * @createTime 2022/12/7 - 0:03
 * @description
 */
@Getter
@Slf4j
@Component
@AllArgsConstructor
public class DefaultDrawExe extends BaseDrawExe {

    private final AwardGateway awardGateway;
    private final PrizeGateway prizeGateway;
    private final TransactionTemplate transactionTemplate;


    @Override
    protected void addRecord(ActivityDrawContext context) {

    }

    @Override
    protected Boolean drawBefore(ActivityDrawContext context) {

        return transactionTemplate.execute(status -> {
            Boolean seccess = Boolean.TRUE;
            try {
                // 这里需要优化
                // 扣减库存
                int update = awardGateway.deductionAwardNumber(context.getAwardVO().getId(), 1);
                AssertUtil.isTrue(update != 1, "扣减库存失败！");
                // 插入记录
                addRecord(context);
            } catch (Exception e) {
                //错误处理
                status.setRollbackOnly();
                // 回退库存
                awardGateway.deductionAwardNumber(context.getAwardVO().getId(), -1);
                log.error("扣减库存和插入记录出错", e);
                seccess = Boolean.FALSE;
            }
            return seccess;
        });
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
