package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/12/4 - 23:18
 * @description
 */
public interface ActivityRuleGateway {

    ActivityRuleEntity save(ActivityRuleEntity entity);

    List<ActivityRuleEntity> list(ActivityRuleListByParamQuery query);

    void deleteByActivityId(Long activityId);
}
