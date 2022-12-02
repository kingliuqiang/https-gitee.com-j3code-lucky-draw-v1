package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckydomain.activity.ActivityEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/12/3 - 0:01
 * @description
 */
public interface ActivityGateway {

    ActivityEntity save(ActivityEntity entity);


    IPage<ActivityEntity> page(ActivityListByParamQuery query);

}
