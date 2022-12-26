package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;
import cn.j3code.luckydomain.gateway.AcceptPrizeGateway;
import cn.j3code.luckyinfrastructure.convertor.AcceptPrizeConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AcceptPrizeDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.AcceptPrizeMapper;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.RecordMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/26 - 23:18
 * @description
 */
@Component
@AllArgsConstructor
@Slf4j
public class AcceptPrizeGatewayImpl implements AcceptPrizeGateway {

    private final AcceptPrizeMapper acceptPrizeMapper;
    private final RecordMapper recordMapper;

    @Override
    public AcceptPrizeEntity save(AcceptPrizeEntity toEntity) {
        AcceptPrizeDB acceptPrizeDB = AcceptPrizeConvertor.toAcceptPrizeDB(toEntity);
        AssertUtil.isTrue(acceptPrizeMapper.insert(acceptPrizeDB) <= 0, LdExceptionEnum.ADD_ERROR.getDescription());

        return AcceptPrizeConvertor.toEntity(acceptPrizeDB);
    }

    @Override
    public AcceptPrizeEntity one(Long recordId) {
        AcceptPrizeDB acceptPrizeDB = acceptPrizeMapper.getByRecordId(recordId);

        return AcceptPrizeConvertor.toEntity(acceptPrizeDB);
    }
}
