package cn.j3code.luckydomain.gateway;

import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckydomain.record.RecordEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/12/9 - 23:30
 * @description
 */
public interface RecordGateway {

    RecordEntity save(RecordEntity entity);

    IPage<RecordEntity> page(RecordListByParamQuery query);

    Boolean updateStatus(Long id, Integer status);

}
