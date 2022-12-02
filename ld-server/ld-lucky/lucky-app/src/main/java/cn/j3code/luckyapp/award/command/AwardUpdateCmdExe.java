package cn.j3code.luckyapp.award.command;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.AwardUpdateCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.award.command
 * @createTime 2022/12/2 - 22:47
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardUpdateCmdExe {
    private final AwardGateway awardGateway;
    public AwardVO execute(AwardUpdateCmd cmd) {
        AwardEntity entity = awardGateway.save(AwardAssembler.toUpdateEntity(cmd));

        return AwardAssembler.toAwardVO(entity);
    }
}
