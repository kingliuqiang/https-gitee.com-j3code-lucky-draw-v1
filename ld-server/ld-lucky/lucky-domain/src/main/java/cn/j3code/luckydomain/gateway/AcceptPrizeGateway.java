package cn.j3code.luckydomain.gateway;

import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/12/26 - 23:00
 * @description
 */
public interface AcceptPrizeGateway {

    AcceptPrizeEntity save(AcceptPrizeEntity toEntity);

    AcceptPrizeEntity one(Long recordId);
}
