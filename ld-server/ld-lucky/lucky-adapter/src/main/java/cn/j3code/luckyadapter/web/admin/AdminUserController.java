package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web.admin
 * @createTime 2022/11/29 - 23:51
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/user")
public class AdminUserController {

    private final IUserService userService;

    @PostMapping("/page")
    public IPage<UserVO> page(@RequestBody UserListByParamQuery query) {
        return userService.page(query);
    }


    @PostMapping("/one")
    public UserVO one(@RequestParam(value = "id") Long id) {
        return userService.one(id);
    }
}
