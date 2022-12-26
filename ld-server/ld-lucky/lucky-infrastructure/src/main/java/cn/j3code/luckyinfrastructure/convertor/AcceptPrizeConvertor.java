package cn.j3code.luckyinfrastructure.convertor;

import cn.j3code.luckydomain.acceptprize.AcceptPrizeEntity;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AcceptPrizeDB;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/12/26 - 23:01
 * @description
 */
public class AcceptPrizeConvertor {
    public static AcceptPrizeDB toAcceptPrizeDB(AcceptPrizeEntity toEntity) {
        AcceptPrizeDB acceptPrizeDB = new AcceptPrizeDB();
        acceptPrizeDB.setRecordId(toEntity.getRecordId());
        acceptPrizeDB.setPhone(toEntity.getPhone());
        acceptPrizeDB.setAddress(toEntity.getAddress());
        acceptPrizeDB.setCreateTime(toEntity.getCreateTime());
        acceptPrizeDB.setCreator(toEntity.getCreator());
        acceptPrizeDB.setUpdateTime(toEntity.getUpdateTime());
        acceptPrizeDB.setUpdater(toEntity.getUpdater());

        return acceptPrizeDB;
    }

    public static AcceptPrizeEntity toEntity(AcceptPrizeDB acceptPrizeDB) {
        AcceptPrizeEntity entity = new AcceptPrizeEntity();
        entity.setId(acceptPrizeDB.getId());
        entity.setRecordId(acceptPrizeDB.getRecordId());
        entity.setPhone(acceptPrizeDB.getPhone());
        entity.setAddress(acceptPrizeDB.getAddress());
        entity.setCreateTime(acceptPrizeDB.getCreateTime());
        entity.setCreator(acceptPrizeDB.getCreator());
        entity.setUpdateTime(acceptPrizeDB.getUpdateTime());
        entity.setUpdater(acceptPrizeDB.getUpdater());

        return entity;
    }
}
