package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckydomain.award.AwardEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/12/2 - 22:55
 * @description
 */
public interface AwardGateway {

    AwardEntity save(AwardEntity entity);

    IPage<AwardEntity> page(AwardListByParamQuery query);

}
