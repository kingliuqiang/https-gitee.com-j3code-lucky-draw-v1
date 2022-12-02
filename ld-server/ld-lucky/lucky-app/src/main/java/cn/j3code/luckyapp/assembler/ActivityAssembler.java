package cn.j3code.luckyapp.assembler;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.ActivityUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.activity.ActivityTime;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.assembler
 * @createTime 2022/12/3 - 0:03
 * @description
 */
public class ActivityAssembler {
    public static ActivityEntity toAddEntity(ActivityAddCmd cmd) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityName(cmd.getActivityName());
        activityEntity.setActivityTime(new ActivityTime(cmd.getStartTime(), cmd.getEndTime()));
        activityEntity.setDescribe(cmd.getDescribe());
        activityEntity.setCreateTime(LocalDateTime.now());
        activityEntity.setCreator(SecurityUtil.getName());
        activityEntity.setUpdateTime(LocalDateTime.now());
        activityEntity.setUpdater(SecurityUtil.getName());

        return activityEntity;
    }

    public static ActivityVO toActivityVO(ActivityEntity entity) {
        ActivityVO activityVO = new ActivityVO();
        activityVO.setId(entity.getId());
        activityVO.setActivityName(entity.getActivityName());
        activityVO.setStartTime(entity.getActivityTime().getStartTime());
        activityVO.setEndTime(entity.getActivityTime().getEndTime());
        activityVO.setDescribe(entity.getDescribe());
        activityVO.setCreateTime(entity.getCreateTime());
        activityVO.setCreator(entity.getCreator());
        activityVO.setUpdateTime(entity.getUpdateTime());
        activityVO.setUpdater(entity.getUpdater());


        return activityVO;
    }

    public static ActivityEntity toUpdateEntity(ActivityUpdateCmd cmd) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(cmd.getId());
        activityEntity.setActivityName(cmd.getActivityName());
        activityEntity.setActivityTime(new ActivityTime(cmd.getStartTime(), cmd.getEndTime()));
        activityEntity.setDescribe(cmd.getDescribe());
        activityEntity.setUpdateTime(LocalDateTime.now());
        activityEntity.setUpdater(SecurityUtil.getName());

        return activityEntity;
    }
}
