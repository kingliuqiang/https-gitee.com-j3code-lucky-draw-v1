package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.ActivityRuleAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/4 - 23:03
 * @description
 */
public interface IActivityRuleService {

    ActivityRuleVO add(ActivityRuleAddCmd cmd);

    List<ActivityRuleVO> list(ActivityRuleListByParamQuery query);
}
