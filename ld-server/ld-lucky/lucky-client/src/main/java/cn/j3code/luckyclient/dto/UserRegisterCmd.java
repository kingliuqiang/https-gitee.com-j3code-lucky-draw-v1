package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/11/26 - 23:43
 * @description
 */
@Data
public class UserRegisterCmd extends Command {

    /**
     * 账号
     */
    @NotNull(message = "账号不为空")
    private String username;

    @NotNull(message = "密码不为空")
    private String password;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不为空")
    private String name;

    /**
     * 电话
     */
    @NotNull(message = "电话不为空")
    private String phone;

}
