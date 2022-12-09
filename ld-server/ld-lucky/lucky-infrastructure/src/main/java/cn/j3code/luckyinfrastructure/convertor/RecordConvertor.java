package cn.j3code.luckyinfrastructure.convertor;
import cn.j3code.luckydomain.record.RecordEntity;
import cn.j3code.luckydomain.record.RecordStatus;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RecordDB;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/12/9 - 23:00
 * @description
 */
public class RecordConvertor {
    public static RecordDB toRecordDB(RecordEntity entity) {
        RecordDB recordDB = new RecordDB();
        recordDB.setId(entity.getId());
        recordDB.setUserId(entity.getUserId());
        recordDB.setActivityId(entity.getActivityId());
        recordDB.setActivityName(entity.getActivityName());
        recordDB.setAwardId(entity.getAwardId());
        recordDB.setIsWinning(entity.getIsWinning());
        recordDB.setState(entity.getState().getState());
        recordDB.setCreateTime(entity.getCreateTime());
        recordDB.setCreator(entity.getCreator());
        recordDB.setUpdateTime(entity.getUpdateTime());
        recordDB.setUpdater(entity.getUpdater());

        return recordDB;
    }

    public static RecordEntity toEntity(RecordDB recordDB) {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setId(recordEntity.getId());
        recordEntity.setUserId(recordEntity.getUserId());
        recordEntity.setActivityId(recordEntity.getActivityId());
        recordEntity.setActivityName(recordEntity.getActivityName());
        recordEntity.setAwardId(recordEntity.getAwardId());
        recordEntity.setIsWinning(recordEntity.getIsWinning());
        recordEntity.setState(new RecordStatus(recordEntity.getState().getState()));
        recordEntity.setCreateTime(recordEntity.getCreateTime());
        recordEntity.setCreator(recordEntity.getCreator());
        recordEntity.setUpdateTime(recordEntity.getUpdateTime());
        recordEntity.setUpdater(recordEntity.getUpdater());

        return recordEntity;
    }
}
