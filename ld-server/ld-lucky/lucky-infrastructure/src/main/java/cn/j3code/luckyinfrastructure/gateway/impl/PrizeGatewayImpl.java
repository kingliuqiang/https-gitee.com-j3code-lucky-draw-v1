package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import cn.j3code.luckydomain.prize.PrizeEntity;
import cn.j3code.luckyinfrastructure.convertor.PrizeConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.PrizeDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.PrizeMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/1 - 22:33
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeGatewayImpl implements PrizeGateway {

    /**
     * 构造器注入
     */
    private final PrizeMapper prizeMapper;

    @Override
    public PrizeEntity save(PrizeEntity entity) {
        if (Objects.isNull(entity.getId())){
            return addPrize(entity);
        }
        return updatePrize(entity);
    }

    private PrizeEntity updatePrize(PrizeEntity entity) {
        PrizeDB prizeDB = PrizeConvertor.toPrizeDB(entity);

        AssertUtil.isTrue(prizeMapper.updateById(prizeDB) <= 0,
                LdExceptionEnum.UPDATE_ERROR.getDescription());

        return PrizeConvertor.toEntity(prizeDB);
    }

    private PrizeEntity addPrize(PrizeEntity entity) {
        PrizeDB prizeDB = PrizeConvertor.toPrizeDB(entity);

        AssertUtil.isTrue(prizeMapper.insert(prizeDB) <= 0,
                LdExceptionEnum.ADD_ERROR.getDescription());

        return PrizeConvertor.toEntity(prizeDB);
    }

    @Override
    public IPage<PrizeEntity> page(PrizeListByParamQuery query) {
        IPage<PrizeDB> page = prizeMapper.page(new Page<PrizeDB>(query.getPageIndex(), query.getPageSize()), query);
        return page.convert(PrizeConvertor::toEntity);
    }

    @Override
    public int deductionInventory(Long prizeId, Integer number) {
        return prizeMapper.deductionInventory(prizeId, number);
    }
}
