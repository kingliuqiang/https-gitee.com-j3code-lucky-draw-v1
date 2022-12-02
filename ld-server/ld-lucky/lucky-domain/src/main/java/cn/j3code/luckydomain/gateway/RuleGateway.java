package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import cn.j3code.luckydomain.rule.RuleEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/12/1 - 22:24
 * @description
 */
public interface RuleGateway {


    RuleEntity save(RuleEntity entity);

    IPage<RuleEntity> page(RuleListByParamQuery query);

}
