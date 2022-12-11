package cn.j3code.luckyapp.context;

import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.context
 * @createTime 2022/12/8 - 22:22
 * @description
 */
@Data
@Accessors(chain = true)
public class ActivityDrawContext {

    private ActivityConfigVO activityConfigVO;

    /**
     * 抽奖算法获得到的奖项
     */
    private AwardVO awardVO;
    /**
     * 抽奖算法获得到的奖项entity
     */
    private AwardEntity awardEntity;

    /**
     * 是否中奖,true:中奖
     */
    private Boolean isWinTheLottery;

    /**
     * 是否可见，用户中奖日志是否可见
     */
    private Boolean isShow;

    /**
     * 中奖记录id
     */
    private Long recordId;

}
