package cn.j3code.luckyinfrastructure.convertor;
import cn.j3code.luckydomain.prize.Tnventory;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckydomain.prize.PrizeEntity;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.PrizeDB;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/12/1 - 22:39
 * @description
 */
public class PrizeConvertor {
    public static PrizeDB toPrizeDB(PrizeEntity entity) {
        PrizeDB prizeDB = new PrizeDB();
        prizeDB.setId(entity.getId());
        prizeDB.setPrizeName(entity.getPrizeName());
        prizeDB.setInventory(entity.getInventory().getInventory());
        prizeDB.setMoney(new BigDecimal(entity.getMoney().toString()));
        prizeDB.setType(entity.getType());
        prizeDB.setCreateTime(LocalDateTime.now());
        prizeDB.setCreator(SecurityUtil.getName());
        prizeDB.setUpdateTime(LocalDateTime.now());
        prizeDB.setUpdater(SecurityUtil.getName());


        return prizeDB;
    }

    public static PrizeEntity toEntity(PrizeDB prizeDB) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setId(prizeDB.getId());
        prizeEntity.setPrizeName(prizeDB.getPrizeName());
        prizeEntity.setInventory(new Tnventory(prizeDB.getInventory()));
        prizeEntity.setMoney(new BigDecimal(prizeDB.getMoney().toString()));
        prizeEntity.setType(prizeDB.getType());
        prizeEntity.setCreateTime(prizeDB.getCreateTime());
        prizeEntity.setCreator(prizeDB.getCreator());
        prizeEntity.setUpdateTime(prizeDB.getUpdateTime());
        prizeEntity.setUpdater(prizeDB.getUpdater());

        return prizeEntity;
    }
}
