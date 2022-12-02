package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.config.exception.ldException;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.gateway.ActivityGateway;
import cn.j3code.luckyinfrastructure.convertor.ActivityConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.ActivityMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/3 - 0:08
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityGatewayImpl implements ActivityGateway {

    private final ActivityMapper activityMapper;

    @Override
    public ActivityEntity save(ActivityEntity entity) {
        if (Objects.isNull(entity.getId())) {
            return addActivity(entity);
        }
        return updateActivity(entity);
    }

    private ActivityEntity updateActivity(ActivityEntity entity) {
        ActivityDB activityDB = ActivityConvertor.toActivityDB(entity);

        int update = activityMapper.updateById(activityDB);
        if (update <= 0) {
            throw new ldException("修改数据失败！");
        }

        return ActivityConvertor.toEntity(activityDB);
    }

    private ActivityEntity addActivity(ActivityEntity entity) {
        ActivityDB activityDB = ActivityConvertor.toActivityDB(entity);

        int insert = activityMapper.insert(activityDB);
        if (insert <= 0) {
            throw new ldException("保存数据失败！");
        }

        return ActivityConvertor.toEntity(activityDB);
    }

    @Override
    public IPage<ActivityEntity> page(ActivityListByParamQuery query) {
        IPage<ActivityDB> page = activityMapper.page(new Page<ActivityDB>(query.getPageIndex(), query.getPageSize()), query);
        return page.convert(ActivityConvertor::toEntity);
    }
}
