package cn.j3code.luckyapp.activity.command;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.data.DrawResultVO;
import cn.j3code.luckydomain.award.AwardEntity;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activity.command
 * @createTime 2022/12/6 - 23:59
 * @description
 */
public abstract class BaseDrawExe {

    public DrawResultVO execute(ActivityConfigVO activityConfigVO) {
        // 校验活动时间
        checkActivityTime(activityConfigVO.getActivityVO());
        // 校验活动规则
        checkActivityRule(activityConfigVO);
        // 剔除奖项库存为空的项
        List<AwardVO> awardVOList = removeAwardInventoryNull(activityConfigVO.getAwardVOList());
        // 调用抽奖算法进行抽奖
        AwardVO awardVO = getAward(awardVOList);

        AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
        if (Boolean.FALSE.equals(awardEntity.isPrize())) {
            return getDrawResultVO(awardEntity);
        }
        // 扣减奖项库存
        if (defaultDeductionAwardNumber(activityConfigVO.getActivityVO().getId(), awardEntity.getId()) != 1) {
            return getDefaultDrawResultVO(awardVOList);
        }

        // 插入获奖记录
        addAcceptPrize(activityConfigVO.getActivityVO().getId(), awardEntity);
        // 返回结果
        return getDrawResultVO(awardEntity);
    }

    protected abstract void addAcceptPrize(Long id, AwardEntity awardEntity);

    public Integer defaultDeductionAwardNumber(Long activityId, Long awardId) {
        return deductionAwardNumber(awardId, 1);
    }

    private DrawResultVO getDefaultDrawResultVO(List<AwardVO> awardVOList) {
        DrawResultVO result = new DrawResultVO();
        for (AwardVO awardVO : awardVOList) {
            if ("0".equals(awardVO.getPrizeId().toString())) {
                result = getDrawResultVO(AwardAssembler.toAwardEntity(awardVO));
                break;
            }
        }
        return result;
    }

    protected abstract int deductionAwardNumber(Long awardId, Integer number);

    protected abstract DrawResultVO getDrawResultVO(AwardEntity awardEntity);

    protected abstract AwardVO getAward(List<AwardVO> awardVOList);

    protected abstract List<AwardVO> removeAwardInventoryNull(List<AwardVO> awardVOList);

    protected abstract void checkActivityRule(ActivityConfigVO activityConfigVO);

    /**
     * 校验活动
     *
     * @param activityVO
     */
    protected abstract void checkActivityTime(ActivityVO activityVO);
}
