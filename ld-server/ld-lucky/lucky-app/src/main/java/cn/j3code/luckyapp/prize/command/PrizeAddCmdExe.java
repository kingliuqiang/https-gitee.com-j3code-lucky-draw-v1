package cn.j3code.luckyapp.prize.command;

import cn.j3code.luckyapp.assembler.PrizeAssembler;
import cn.j3code.luckyclient.dto.PrizeAddCmd;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import cn.j3code.luckydomain.prize.PrizeEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.prize
 * @createTime 2022/12/1 - 22:20
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeAddCmdExe {

    private final PrizeGateway prizeGateway;

    public PrizeVO execute(PrizeAddCmd cmd) {
        PrizeEntity prizeEntity = prizeGateway.save(PrizeAssembler.toAddEntity(cmd));

        return PrizeAssembler.toPrizeVO(prizeEntity);
    }
}
