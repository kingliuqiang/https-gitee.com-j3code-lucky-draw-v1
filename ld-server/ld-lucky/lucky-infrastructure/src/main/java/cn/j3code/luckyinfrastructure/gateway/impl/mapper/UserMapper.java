package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckydomain.user.UserEntity;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.UserDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【bld_user】的数据库操作Mapper
* @createDate 2022-11-26 23:00:36
* @Entity cn.j3code.lduser.po.User
*/
public interface UserMapper extends BaseMapper<UserDB> {

    UserDB findByUserName(@Param("id") Long id, @Param("username") String username);

    IPage<UserDB> listByParamQuery(@Param("page") Page<UserEntity> userEntityPage, @Param("query") UserListByParamQuery query);
}




