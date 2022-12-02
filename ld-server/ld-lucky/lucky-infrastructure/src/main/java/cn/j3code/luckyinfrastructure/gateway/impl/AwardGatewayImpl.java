package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.exception.ldException;
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

        int insert = awardMapper.insert(awardDB);
        if (insert <= 0) {
            throw new ldException("保存数据失败！");
        }

        return AwardConvertor.toEntity(awardDB);
    }

    private AwardEntity updateAward(AwardEntity entity) {
        AwardDB awardDB = AwardConvertor.toAwardDB(entity);

        int update = awardMapper.updateById(awardDB);
        if (update <= 0) {
            throw new ldException("修改数据失败！");
        }

        return AwardConvertor.toEntity(awardDB);
    }

    @Override
    public IPage<AwardEntity> page(AwardListByParamQuery query) {
        IPage<AwardDB> page = awardMapper.page(new Page<AwardDB>(query.getPageIndex(), query.getPageSize()), query);

        return page.convert(AwardConvertor::toEntity);
    }
}
