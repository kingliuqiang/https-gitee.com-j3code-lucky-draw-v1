package cn.j3code.luckyinfrastructure.convertor;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.activity.ActivityTime;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityDB;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/12/3 - 0:09
 * @description
 */
public class ActivityConvertor {
    public static ActivityDB toActivityDB(ActivityEntity entity) {
        ActivityDB activityDB = new ActivityDB();
        activityDB.setId(entity.getId());
        activityDB.setActivityName(entity.getActivityName());
        activityDB.setStartTime(entity.getActivityTime().getStartTime());
        activityDB.setEndTime(entity.getActivityTime().getEndTime());
        activityDB.setDescribe(entity.getDescribe());
        activityDB.setCreateTime(entity.getCreateTime());
        activityDB.setCreator(entity.getCreator());
        activityDB.setUpdateTime(entity.getUpdateTime());
        activityDB.setUpdater(entity.getUpdater());

        return activityDB;
    }

    public static ActivityEntity toEntity(ActivityDB activityDB) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(activityDB.getId());
        activityEntity.setActivityName(activityDB.getActivityName());
        activityEntity.setActivityTime(new ActivityTime(activityDB.getStartTime(), activityDB.getEndTime()));
        activityEntity.setDescribe(activityDB.getDescribe());
        activityEntity.setCreateTime(activityDB.getCreateTime());
        activityEntity.setCreator(activityDB.getCreator());
        activityEntity.setUpdateTime(activityDB.getUpdateTime());
        activityEntity.setUpdater(activityDB.getUpdater());


        return activityEntity;
    }
}
