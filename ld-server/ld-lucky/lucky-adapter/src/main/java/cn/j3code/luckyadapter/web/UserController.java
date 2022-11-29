package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web
 * @createTime 2022/11/28 - 21:58
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/user")
public class UserController {

    private final IUserService userService;

    @PostMapping("/register")
    public UserVO register(@Validated @RequestBody UserRegisterCmd cmd) {
        return userService.register(cmd);
    }

}
