package cn.j3code.luckyapp.user.command;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import com.alibaba.cola.exception.SysException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.user.command
 * @createTime 2022/11/28 - 22:02
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserRegisterCmdExe {

    private final UserGateway userGateway;

    public UserVO execute(UserRegisterCmd cmd) {
        /*
        1、校验用户账号是否存在
        2、注册
         */
        UserEntity lodEntity = userGateway.findByUserName(null, cmd.getUsername());
        if (Objects.nonNull(lodEntity)) {
            throw new SysException("账号存在！");
        }
        UserEntity entity = userGateway.save(UserAssembler.toAddEntity(cmd));
        return UserAssembler.toUserVO(entity);
    }

}
