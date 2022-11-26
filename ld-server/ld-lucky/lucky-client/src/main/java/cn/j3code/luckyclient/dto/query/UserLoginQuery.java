package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/11/26 - 23:46
 * @description
 */
@Data
public class UserLoginQuery extends Query {

    @NotNull(message = "账号不为空")
    private String username;

    @NotNull(message = "密码不为空")
    private String password;
}
