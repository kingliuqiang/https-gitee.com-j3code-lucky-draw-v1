package cn.j3code.luckyapp.activity.command;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.data.DrawResultVO;
import cn.j3code.luckydomain.award.AwardEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activity.command
 * @createTime 2022/12/6 - 23:59
 * @description
 */
@Slf4j
public abstract class BaseDrawExe {


    /**
     * 抽奖模板方法，流程不会改动
     *
     * @param context
     * @return
     */
    public final DrawResultVO execute(ActivityDrawContext context) {
        // 校验活动时间
        checkActivityTime(context.getActivityConfigVO().getActivityVO());
        // 校验活动规则
        checkActivityRule(context.getActivityConfigVO());
        // 剔除奖项库存为空的项
        List<AwardVO> awardVOList = removeAwardInventoryNull(context.getActivityConfigVO().getAwardVOList());
        // 调用抽奖算法进行抽奖
        context.setAwardVO(getAward(awardVOList));

        context.setAwardEntity(AwardAssembler.toAwardEntity(context.getAwardVO()));
        context.setIsWinTheLottery(context.getAwardEntity().isPrize());
        if (Boolean.FALSE.equals(context.getIsWinTheLottery())) {
            // 插入未中奖记录
            return addRecordAndGetDrawResultVO(context);
        }

        Boolean drawBefore = Boolean.TRUE;
        try {
            // 调用抽奖后续流程，流程内容自定义
            drawBefore = drawBefore(context);
        } catch (Exception e) {
            //错误处理
            drawBefore = Boolean.FALSE;
            log.error("执行drawBefore方法出错，默认返回未中奖信息，", e);
        }

        if (Boolean.FALSE.equals(drawBefore)) {
            // 执行 drawBefore 出错，默认返回未中奖
            context.setAwardVO(getNotAward(context.getActivityConfigVO().getAwardVOList()));
            context.setAwardEntity(AwardAssembler.toAwardEntity(context.getAwardVO()));
            context.setIsWinTheLottery(Boolean.FALSE);
            return addRecordAndGetDrawResultVO(context);
        }

        // 返回结果
        return getDrawResultVO(context.getAwardEntity());
    }

    protected abstract DrawResultVO addRecordAndGetDrawResultVO(ActivityDrawContext context);

    protected abstract Boolean drawBefore(ActivityDrawContext context);

    protected abstract void addRecord(ActivityDrawContext context);

    protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);

    protected abstract AwardVO getAward(List<AwardVO> awardVOList);

    protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);

    /**
     * 校验活动
     *
     * @param activityVO
     */
    protected abstract void checkActivityTime(ActivityVO activityVO);



    private AwardVO getNotAward(List<AwardVO> awardVOList) {
        for (AwardVO awardVO : awardVOList) {
            if ("0".equals(awardVO.getPrizeId().toString())) {
                return awardVO;
            }
        }
        return null;
    }

    private DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList) {
        return getDrawResultVO(AwardAssembler.toAwardEntity(getNotAward(awardVOList)));
    }

    private  List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList){
        if (CollectionUtil.isEmpty(awardVOList)) {
            return new ArrayList<>();
        }
        return awardVOList.stream()
                .filter(item -> item.getNumber() > 0 || "0".equals(item.getPrizeId().toString()))
                .collect(Collectors.toList());
    }

}
