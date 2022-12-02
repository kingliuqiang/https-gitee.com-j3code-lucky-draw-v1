package cn.j3code.luckyapp.assembler;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.dto.RuleAddCmd;
import cn.j3code.luckyclient.dto.RuleUpdateCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckydomain.rule.MinNumber;
import cn.j3code.luckydomain.rule.RuleEntity;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.assembler
 * @createTime 2022/12/1 - 23:38
 * @description
 */
public class RuleAssembler {
    public static RuleEntity toAddEntity(RuleAddCmd cmd) {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setRuleName(cmd.getRuleName());
        ruleEntity.setMaxJoinNumber(new MinNumber(cmd.getMaxJoinNumber()));
        ruleEntity.setMaxWinningNumber(new MinNumber(cmd.getMaxWinningNumber()));
        ruleEntity.setCreateTime(LocalDateTime.now());
        ruleEntity.setCreator(SecurityUtil.getName());
        ruleEntity.setUpdateTime(LocalDateTime.now());
        ruleEntity.setUpdater(SecurityUtil.getName());

        return ruleEntity;
    }

    public static RuleVO toRuleVO(RuleEntity entity) {
        RuleVO ruleVO = new RuleVO();
        ruleVO.setId(entity.getId());
        ruleVO.setRuleName(entity.getRuleName());
        ruleVO.setMaxJoinNumber(entity.getMaxJoinNumber().getNumber());
        ruleVO.setMaxWinningNumber(entity.getMaxWinningNumber().getNumber());
        ruleVO.setCreateTime(entity.getCreateTime());
        ruleVO.setCreator(entity.getCreator());
        ruleVO.setUpdateTime(entity.getUpdateTime());
        ruleVO.setUpdater(entity.getUpdater());

        return ruleVO;
    }

    public static RuleEntity toUpdateEntity(RuleUpdateCmd cmd) {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setId(cmd.getId());
        ruleEntity.setRuleName(cmd.getRuleName());
        ruleEntity.setMaxJoinNumber(new MinNumber(cmd.getMaxJoinNumber()));
        ruleEntity.setMaxWinningNumber(new MinNumber(cmd.getMaxWinningNumber()));
        ruleEntity.setCreateTime(LocalDateTime.now());
        ruleEntity.setCreator(SecurityUtil.getName());
        ruleEntity.setUpdateTime(LocalDateTime.now());
        ruleEntity.setUpdater(SecurityUtil.getName());

        return ruleEntity;
    }
}
