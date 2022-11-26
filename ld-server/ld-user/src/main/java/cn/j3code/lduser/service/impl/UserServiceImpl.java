package cn.j3code.lduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.j3code.lduser.po.User;
import cn.j3code.lduser.service.UserService;
import cn.j3code.lduser.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【bld_user】的数据库操作Service实现
* @createDate 2022-11-26 23:00:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




