package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/11/26 - 23:48
 * @description
 */
@Data
public class UserListByParamQuery extends PageQuery {

    private Long id;

    private String name;

    private String phone;
}
