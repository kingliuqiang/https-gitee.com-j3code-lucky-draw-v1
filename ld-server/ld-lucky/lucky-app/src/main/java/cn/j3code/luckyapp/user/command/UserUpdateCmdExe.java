package cn.j3code.luckyapp.user.command;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserUpdateCmd;
import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.user.command
 * @createTime 2022/11/29 - 23:36
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserUpdateCmdExe {
    private final UserGateway userGateway;

    public UserVO execute(UserUpdateCmd cmd) {
        UserEntity save = userGateway.save(UserAssembler.toUpdateEntity(cmd));
        return UserAssembler.toUserVO(save);
    }
}
