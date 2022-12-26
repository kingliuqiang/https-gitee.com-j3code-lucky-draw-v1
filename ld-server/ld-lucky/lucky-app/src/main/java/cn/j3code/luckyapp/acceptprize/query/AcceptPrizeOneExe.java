package cn.j3code.luckyapp.acceptprize.query;

import cn.j3code.luckyapp.assembler.AcceptPrizeAssembler;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;
import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;
import cn.j3code.luckydomain.gateway.AcceptPrizeGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.acceptprize.query
 * @createTime 2022/12/26 - 23:09
 * @description
 */
@Component
@Slf4j
@AllArgsConstructor
public class AcceptPrizeOneExe {

    private final AcceptPrizeGateway acceptPrizeGateway;


    public AcceptPrizeVO execute(Long recordId) {
        AcceptPrizeEntity entity = acceptPrizeGateway.one(recordId);

        return AcceptPrizeAssembler.toAcceptPrizeVO(entity);
    }
}
