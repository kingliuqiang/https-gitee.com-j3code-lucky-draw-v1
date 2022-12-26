package cn.j3code.luckyapp.acceptprize.command;

import cn.j3code.luckyapp.assembler.AcceptPrizeAssembler;
import cn.j3code.luckyclient.dto.AcceptPrizeAddCmd;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;
import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;
import cn.j3code.luckydomain.gateway.AcceptPrizeGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.acceptprize.command
 * @createTime 2022/12/26 - 23:09
 * @description
 */
@Component
@Slf4j
@AllArgsConstructor
public class AcceptPrizeAddCmdExe {

    private final AcceptPrizeGateway acceptPrizeGateway;

    public AcceptPrizeVO execute(AcceptPrizeAddCmd cmd) {
        AcceptPrizeEntity entity = acceptPrizeGateway.save(AcceptPrizeAssembler.toEntity(cmd));

        return AcceptPrizeAssembler.toAcceptPrizeVO(entity);
    }
}
