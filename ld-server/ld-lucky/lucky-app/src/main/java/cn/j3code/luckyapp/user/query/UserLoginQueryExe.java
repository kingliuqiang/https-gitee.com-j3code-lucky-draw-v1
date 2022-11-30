package cn.j3code.luckyapp.user.query;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckydomain.gateway.UserGateway;
import com.alibaba.cola.exception.SysException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.user.query
 * @createTime 2022/11/29 - 21:49
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserLoginQueryExe {

    private final UserGateway userGateway;


    public UserVO execute(UserLoginQuery query) {
        // 根据账号查询用户
        final var userEntity = userGateway.findByUserName(null, query.getUsername());

        // 不存在报错
        if (Objects.isNull(userEntity)){
            throw new SysException("登录失败，用户不存在！");
        }

        // 判断用户密码
        if (Boolean.FALSE.equals(userEntity.getPassword().isEqual(query.getPassword()))){
            throw new SysException("登录失败，密码错误！");
        }

        return UserAssembler.toUserVO(userEntity);
    }
}
