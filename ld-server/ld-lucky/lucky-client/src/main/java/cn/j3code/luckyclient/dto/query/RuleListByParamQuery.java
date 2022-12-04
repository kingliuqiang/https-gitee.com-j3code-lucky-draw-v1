package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/12/1 - 23:27
 * @description
 */
@Data
public class RuleListByParamQuery extends PageQuery {

    private Long id;

    private List<Long> ids;

    private String ruleName;

}
