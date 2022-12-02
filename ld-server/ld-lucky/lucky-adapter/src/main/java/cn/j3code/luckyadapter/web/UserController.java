package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckyclient.dto.UserUpdateCmd;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/login")
    public String login(@Validated @RequestBody UserLoginQuery query) {
        return userService.login(query);
    }

    @GetMapping("/one")
    public UserVO one(@RequestParam(value = "id") Long id) {
        return userService.one(id);
    }

    @PostMapping("/update")
    public UserVO update(@Validated @RequestBody UserUpdateCmd cmd) {
        return userService.update(cmd);
    }

}
