package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckydomain.gateway.RecordGateway;
import cn.j3code.luckydomain.record.RecordEntity;
import cn.j3code.luckyinfrastructure.convertor.RecordConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RecordDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.RecordMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/9 - 23:36
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class RecordGatewayImpl implements RecordGateway {

    private final RecordMapper recordMapper;

    @Override
    public RecordEntity save(RecordEntity entity) {
        RecordDB recordDB = RecordConvertor.toRecordDB(entity);
        AssertUtil.isTrue(recordMapper.insert(recordDB) != 1, LdExceptionEnum.ADD_ERROR.getDescription());

        return RecordConvertor.toEntity(recordDB);
    }

    @Override
    public IPage<RecordEntity> page(RecordListByParamQuery query) {
        IPage<RecordDB> page = recordMapper.page(new Page<RecordDB>(query.getPageIndex(), query.getPageSize()), query);

        return page.convert(RecordConvertor::toEntity);
    }

    @Override
    public Boolean updateStatus(Long id, Integer status) {

        return recordMapper.updateStatus(id, status) == 1;
    }
}
