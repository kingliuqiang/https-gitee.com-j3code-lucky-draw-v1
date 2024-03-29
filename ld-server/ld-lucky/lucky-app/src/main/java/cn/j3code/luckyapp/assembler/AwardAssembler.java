package cn.j3code.luckyapp.assembler;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.AwardUpdateCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.award.AwardNumber;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.assembler
 * @createTime 2022/12/2 - 22:57
 * @description
 */
public class AwardAssembler {

    public static AwardEntity toAddEntity(AwardAddCmd cmd) {
        AwardEntity awardEntity = new AwardEntity();
        awardEntity.setPrizeId(cmd.getPrizeId());
        awardEntity.setActivityId(cmd.getActivityId());
        awardEntity.setNumber(new AwardNumber(cmd.getNumber()));
        awardEntity.setAwardName(cmd.getAwardName());
        awardEntity.setProbability(cmd.getProbability());
        awardEntity.setCreateTime(LocalDateTime.now());
        awardEntity.setCreator(SecurityUtil.getName());
        awardEntity.setUpdateTime(LocalDateTime.now());
        awardEntity.setUpdater(SecurityUtil.getName());

        return awardEntity;
    }

    public static AwardVO toAwardVO(AwardEntity entity) {
        AwardVO awardVO = new AwardVO();
        awardVO.setId(entity.getId());
        awardVO.setActivityId(entity.getActivityId());
        awardVO.setPrizeId(entity.getPrizeId());
        awardVO.setNumber(entity.getNumber().getNumber());
        awardVO.setAwardName(entity.getAwardName());
        awardVO.setProbability(entity.getProbability());
        awardVO.setCreateTime(entity.getCreateTime());
        awardVO.setCreator(entity.getCreator());
        awardVO.setUpdateTime(entity.getUpdateTime());
        awardVO.setUpdater(entity.getUpdater());
        awardVO.setPrizeName(entity.getPrizeName());
        return awardVO;
    }

    public static AwardEntity toUpdateEntity(AwardUpdateCmd cmd) {
        AwardEntity awardEntity = new AwardEntity();
        awardEntity.setId(cmd.getId());
        awardEntity.setPrizeId(cmd.getPrizeId());
        awardEntity.setActivityId(cmd.getActivityId());
        awardEntity.setNumber(new AwardNumber(cmd.getNumber()));
        awardEntity.setAwardName(cmd.getAwardName());
        awardEntity.setProbability(cmd.getProbability());
        awardEntity.setUpdateTime(LocalDateTime.now());
        awardEntity.setUpdater(SecurityUtil.getName());

        return awardEntity;
    }

    public static AwardAddCmd toAwardAddCmd(AwardVO awardVO) {
        AwardAddCmd awardAddCmd = new AwardAddCmd();
        awardAddCmd.setPrizeId(awardVO.getPrizeId());
        awardAddCmd.setNumber(awardVO.getNumber());
        awardAddCmd.setAwardName(awardVO.getAwardName());
        awardAddCmd.setProbability(awardVO.getProbability());

        return awardAddCmd;
    }

    public static AwardEntity toAwardEntity(AwardVO awardVO) {
        AwardEntity awardEntity = new AwardEntity();
        awardEntity.setId(awardVO.getId());
        awardEntity.setPrizeId(awardVO.getPrizeId());
        awardEntity.setActivityId(awardVO.getActivityId());
        awardEntity.setNumber(new AwardNumber(awardVO.getNumber()));
        awardEntity.setAwardName(awardVO.getAwardName());
        awardEntity.setProbability(awardVO.getProbability());
        awardEntity.setCreateTime(awardVO.getCreateTime());
        awardEntity.setCreator(awardVO.getCreator());
        awardEntity.setUpdateTime(awardVO.getUpdateTime());
        awardEntity.setUpdater(awardVO.getUpdater());

        return awardEntity;
    }
}
