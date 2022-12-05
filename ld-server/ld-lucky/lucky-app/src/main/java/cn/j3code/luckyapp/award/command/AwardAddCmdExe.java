package cn.j3code.luckyapp.award.command;

import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.award.command
 * @createTime 2022/12/2 - 22:46
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardAddCmdExe {

    private final AwardGateway awardGateway;

    private final PrizeGateway prizeGateway;

    public AwardVO execute(AwardAddCmd cmd) {
        AssertUtil.isTrue(Objects.isNull(cmd.getActivityId()), "奖项活动id不为空！");

        // 保存奖项
        AwardEntity entity = awardGateway.save(AwardAssembler.toAddEntity(cmd));

        // 扣取奖品库存
        if (Boolean.FALSE.equals(entity.isPrize())) {
            // 代表该奖项是谢谢参与一类，不需要扣减奖品库存
            return AwardAssembler.toAwardVO(entity);
        }

        int update = prizeGateway.deductionInventory(cmd.getPrizeId(), cmd.getNumber());
        AssertUtil.isTrue(update < 1, String.format("扣取奖品：%s, 出错，库存不足或奖品不存在！", cmd.getPrizeId()));

        return AwardAssembler.toAwardVO(entity);
    }
}
