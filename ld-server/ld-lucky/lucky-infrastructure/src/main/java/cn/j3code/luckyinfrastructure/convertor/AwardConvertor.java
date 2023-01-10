package cn.j3code.luckyinfrastructure.convertor;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.award.AwardNumber;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AwardDB;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/12/2 - 23:06
 * @description
 */
public class AwardConvertor {
    public static AwardDB toAwardDB(AwardEntity entity) {
        AwardDB awardDB = new AwardDB();
        awardDB.setId(entity.getId());
        awardDB.setPrizeId(entity.getPrizeId());
        awardDB.setActivityId(entity.getActivityId());
        awardDB.setNumber(entity.getNumber().getNumber());
        awardDB.setAwardName(entity.getAwardName());
        awardDB.setProbability(entity.getProbability());
        awardDB.setCreateTime(entity.getCreateTime());
        awardDB.setCreator(entity.getCreator());
        awardDB.setUpdateTime(entity.getUpdateTime());
        awardDB.setUpdater(entity.getUpdater());

        return awardDB;
    }

    public static AwardEntity toEntity(AwardDB awardDB) {
        AwardEntity awardEntity = new AwardEntity();
        awardEntity.setId(awardDB.getId());
        awardEntity.setPrizeId(awardDB.getPrizeId());
        awardEntity.setActivityId(awardDB.getActivityId());
        awardEntity.setNumber(new AwardNumber(awardDB.getNumber()));
        awardEntity.setAwardName(awardDB.getAwardName());
        awardEntity.setProbability(awardDB.getProbability());
        awardEntity.setCreateTime(awardDB.getCreateTime());
        awardEntity.setCreator(awardDB.getCreator());
        awardEntity.setUpdateTime(awardDB.getUpdateTime());
        awardEntity.setUpdater(awardDB.getUpdater());
        awardEntity.setPrizeName(awardDB.getPrizeName());

        return awardEntity;
    }
}
