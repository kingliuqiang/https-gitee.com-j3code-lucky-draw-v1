package cn.j3code.luckyapp.service;

import cn.j3code.luckyapp.user.command.UserRegisterCmdExe;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckyclient.dto.query.UserUpdateCmd;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/11/28 - 21:52
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    /**
     * (构造器注入：循环依赖不能解决，交给Java工程师解决)
     * 体现就是高度内聚
     */
    private final UserRegisterCmdExe userRegisterCmdExe;

    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public UserVO login(UserLoginQuery query) {
        return null;
    }

    @Override
    public IPage<UserVO> page(UserListByParamQuery query) {
        return null;
    }

    @Override
    public UserVO one(Long id) {
        return null;
    }

    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return null;
    }
}
