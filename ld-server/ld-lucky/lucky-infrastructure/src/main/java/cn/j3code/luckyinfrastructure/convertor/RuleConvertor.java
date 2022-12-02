package cn.j3code.luckyinfrastructure.convertor;
import cn.j3code.luckydomain.rule.MinNumber;
import cn.j3code.luckydomain.rule.RuleEntity;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RuleDB;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/12/1 - 23:46
 * @description
 */
public class RuleConvertor {
    public static RuleDB toRuleDB(RuleEntity entity) {
        RuleDB ruleDB = new RuleDB();
        ruleDB.setId(entity.getId());
        ruleDB.setRuleName(entity.getRuleName());
        ruleDB.setMaxJoinNumber(entity.getMaxJoinNumber().getNumber());
        ruleDB.setMaxWinningNumber(entity.getMaxWinningNumber().getNumber());
        ruleDB.setCreateTime(entity.getCreateTime());
        ruleDB.setCreator(entity.getCreator());
        ruleDB.setUpdateTime(entity.getUpdateTime());
        ruleDB.setUpdater(entity.getUpdater());


        return ruleDB;
    }

    public static RuleEntity toEntity(RuleDB ruleDB) {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setId(ruleDB.getId());
        ruleEntity.setRuleName(ruleDB.getRuleName());
        ruleEntity.setMaxJoinNumber(new MinNumber(ruleDB.getMaxJoinNumber()));
        ruleEntity.setMaxWinningNumber(new MinNumber(ruleDB.getMaxWinningNumber()));
        ruleEntity.setCreateTime(ruleDB.getCreateTime());
        ruleEntity.setCreator(ruleDB.getCreator());
        ruleEntity.setUpdateTime(ruleDB.getUpdateTime());
        ruleEntity.setUpdater(ruleDB.getUpdater());

        return ruleEntity;
    }
}
