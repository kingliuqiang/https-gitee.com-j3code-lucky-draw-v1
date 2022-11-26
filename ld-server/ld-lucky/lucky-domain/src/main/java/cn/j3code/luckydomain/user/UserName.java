package cn.j3code.luckydomain.user;

import cn.j3code.config.exception.ldException;
import lombok.Getter;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.user
 * @createTime 2022/11/26 - 23:21
 * @description
 */
@Getter
public class UserName {
    /**
     * 账号
     */
    private String username;

    public UserName(String username) {
        if (Objects.isNull(username)){
            throw new ldException("账号不能为空");
        }
        this.username = username;
    }
}
