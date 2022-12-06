package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import cn.j3code.luckyinfrastructure.convertor.AwardConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AwardDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.AwardMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/2 - 23:03
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardGatewayImpl implements AwardGateway {

    private final AwardMapper awardMapper;

    @Override
    public AwardEntity save(AwardEntity entity) {
        if (Objects.isNull(entity.getId())) {
            return addAward(entity);
        }
        return updateAward(entity);
    }

    private AwardEntity addAward(AwardEntity entity) {
        AwardDB awardDB = AwardConvertor.toAwardDB(entity);

        AssertUtil.isTrue(awardMapper.insert(awardDB) <= 0,
                LdExceptionEnum.ADD_ERROR.getDescription());

        return AwardConvertor.toEntity(awardDB);
    }

    private AwardEntity updateAward(AwardEntity entity) {
        AwardDB awardDB = AwardConvertor.toAwardDB(entity);

        AssertUtil.isTrue(awardMapper.updateById(awardDB) <= 0,
                LdExceptionEnum.UPDATE_ERROR.getDescription());

        return AwardConvertor.toEntity(awardDB);
    }

    @Override
    public IPage<AwardEntity> page(AwardListByParamQuery query) {
        IPage<AwardDB> page = awardMapper.page(new Page<AwardDB>(query.getPageIndex(), query.getPageSize()), query);

        return page.convert(AwardConvertor::toEntity);
    }

    @Override
    public int deductionAwardNumber(Long awardId, Integer number) {

        return awardMapper.deductionAwardNumber(awardId, number);
    }
}
