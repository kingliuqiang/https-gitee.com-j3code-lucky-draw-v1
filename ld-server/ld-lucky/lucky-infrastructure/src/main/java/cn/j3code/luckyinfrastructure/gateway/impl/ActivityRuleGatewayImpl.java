package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;
import cn.j3code.luckydomain.gateway.ActivityRuleGateway;
import cn.j3code.luckyinfrastructure.convertor.ActivityRuleConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityRuleDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.ActivityRuleMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/12/4 - 23:22
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleGatewayImpl implements ActivityRuleGateway {

    private final ActivityRuleMapper activityRuleMapper;

    @Override
    public ActivityRuleEntity save(ActivityRuleEntity entity) {

        ActivityRuleDB activityRuleDB = ActivityRuleConvertor.toActivityRuleDB(entity);

        AssertUtil.isTrue(activityRuleMapper.insert(activityRuleDB) <= 0, LdExceptionEnum.ADD_ERROR.getDescription());

        return ActivityRuleConvertor.toEntity(activityRuleDB);
    }

    @Override
    public List<ActivityRuleEntity> list(ActivityRuleListByParamQuery query) {
        List<ActivityRuleDB> list = activityRuleMapper.list(query);
        if (CollectionUtil.isEmpty(list)){
            return new ArrayList<>();
        }
        return new Page<ActivityRuleDB>()
                .setRecords(list)
                .convert(ActivityRuleConvertor::toEntity)
                .getRecords();
    }

    @Override
    public void deleteByActivityId(Long activityId) {
        activityRuleMapper.deleteByActivityId(activityId);
    }
}
