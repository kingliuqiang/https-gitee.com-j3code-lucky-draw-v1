package cn.j3code.luckyapp.award.command;

import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
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

    public AwardVO execute(AwardAddCmd cmd) {
        AssertUtil.isTrue(Objects.isNull(cmd.getActivityId()), "奖项活动id不为空！");

        AwardEntity entity = awardGateway.save(AwardAssembler.toAddEntity(cmd));

        return AwardAssembler.toAwardVO(entity);
    }
}
