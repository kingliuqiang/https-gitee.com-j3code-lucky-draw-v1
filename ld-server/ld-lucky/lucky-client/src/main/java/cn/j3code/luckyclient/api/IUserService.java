package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckyclient.dto.query.UserLoginQuery;
import cn.j3code.luckyclient.dto.UserUpdateCmd;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/11/26 - 23:41
 * @description
 */
public interface IUserService {

    /**
     * 用户注册
     * @param cmd
     * @return
     */
    UserVO register(UserRegisterCmd cmd);

    /**
     * 用户登录
     * @param query
     * @return
     */
    String login(UserLoginQuery query);


    /**
     * 分页查询
     * @param query
     * @return
     */
    IPage<UserVO> page(UserListByParamQuery query);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    UserVO one(Long id);

    /**
     * 用户修改
     * @param cmd
     * @return
     */
    UserVO update(UserUpdateCmd cmd);
}
