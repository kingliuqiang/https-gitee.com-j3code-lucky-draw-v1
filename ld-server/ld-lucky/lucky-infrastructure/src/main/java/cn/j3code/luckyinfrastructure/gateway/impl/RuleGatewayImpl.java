package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import cn.j3code.luckydomain.gateway.RuleGateway;
import cn.j3code.luckydomain.rule.RuleEntity;
import cn.j3code.luckyinfrastructure.convertor.RuleConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RuleDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.RuleMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/1 - 23:43
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class RuleGatewayImpl implements RuleGateway {

    private final RuleMapper ruleMapper;

    @Override
    public RuleEntity save(RuleEntity entity) {

        if (Objects.isNull(entity.getId())) {
            return addRule(entity);
        }

        return updateRule(entity);
    }

    private RuleEntity addRule(RuleEntity entity) {
        RuleDB ruleDB = RuleConvertor.toRuleDB(entity);

        AssertUtil.isTrue(ruleMapper.insert(ruleDB) <= 0,
                LdExceptionEnum.ADD_ERROR.getDescription());

        return RuleConvertor.toEntity(ruleDB);
    }

    private RuleEntity updateRule(RuleEntity entity) {
        RuleDB ruleDB = RuleConvertor.toRuleDB(entity);

        AssertUtil.isTrue(ruleMapper.updateById(ruleDB) <= 0,
                LdExceptionEnum.UPDATE_ERROR.getDescription());

        return RuleConvertor.toEntity(ruleDB);
    }

    @Override
    public IPage<RuleEntity> page(RuleListByParamQuery query) {
        IPage<RuleDB> page = ruleMapper.page(new Page<RuleDB>(query.getPageIndex(), query.getPageSize()), query);

        return page.convert(RuleConvertor::toEntity);
    }
}
