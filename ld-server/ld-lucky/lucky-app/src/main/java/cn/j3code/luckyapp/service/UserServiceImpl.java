package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollUtil;
import cn.j3code.config.exception.ldException;
import cn.j3code.config.util.JwtUtil;
import cn.j3code.luckyapp.user.command.UserRegisterCmdExe;
import cn.j3code.luckyapp.user.command.UserUpdateCmdExe;
import cn.j3code.luckyapp.user.query.UserListByParamQueryExe;
import cn.j3code.luckyapp.user.query.UserLoginQueryExe;
import cn.j3code.luckyclient.api.IUserService;
import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckyclient.dto.UserUpdateCmd;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    private final UserLoginQueryExe userLoginQueryExe;
    private final UserListByParamQueryExe userListByParamQueryExe;
    private final UserUpdateCmdExe userUpdateCmdExe;

    @Override
    public UserVO register(UserRegisterCmd cmd) {
        return userRegisterCmdExe.execute(cmd);
    }

    @Override
    public String login(UserLoginQuery query) {
        UserVO userVO = userLoginQueryExe.execute(query);
        return JwtUtil.createToken(Map.of("username", userVO.getUsername(), "name", userVO.getName(), "phone", userVO.getPhone()));
    }

    @Override
    public IPage<UserVO> page(UserListByParamQuery query) {
        return userListByParamQueryExe.execute(query);
    }

    @Override
    public UserVO one(Long id) {
        final var query = new UserListByParamQuery();
        query.setId(id);
        IPage<UserVO> iPage = userListByParamQueryExe.execute(query);

        if (CollUtil.isEmpty(iPage.getRecords())) {
            throw new ldException("该用户不存在！");
        }
        return iPage.getRecords().get(0);
    }

    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return userUpdateCmdExe.execute(cmd);
    }
}
