package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/12/1 - 22:12
 * @description
 */
@Data
public class PrizeListByParamQuery extends PageQuery {

    private Long id;

    private String prizeName;

    private Integer type;
}
