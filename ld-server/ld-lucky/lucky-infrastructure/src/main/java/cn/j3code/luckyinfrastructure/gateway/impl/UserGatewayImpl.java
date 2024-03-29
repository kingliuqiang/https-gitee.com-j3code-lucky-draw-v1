package cn.j3code.luckyinfrastructure.gateway.impl;

import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import cn.j3code.luckyinfrastructure.convertor.UserConvertor;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.UserDB;
import cn.j3code.luckyinfrastructure.gateway.impl.mapper.UserMapper;
import com.alibaba.cola.exception.SysException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.gateway.impl
 * @createTime 2022/11/28 - 22:22
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;

    @Override
    public UserEntity save(UserEntity entity) {

        if (Objects.isNull(entity.getId())){
            return addUser(entity);
        }
        return updateUser(entity);
    }

    private UserEntity updateUser(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);

        int update = userMapper.updateById(userDB);
        if (update <= 0) {
            throw new SysException("修改失败！");
        }
        return UserConvertor.toEntity(userDB);
    }

    private UserEntity addUser(UserEntity entity) {
        UserDB userDB = UserConvertor.toUserDB(entity);

        int insert = userMapper.insert(userDB);
        if (insert <= 0) {
            throw new SysException("注册失败！");
        }
        return UserConvertor.toEntity(userDB);
    }

    @Override
    public UserEntity findByUserName(Long id, String username) {
        UserDB userDB = userMapper.findByUserName(id, username);
        if (Objects.isNull(userDB)) {
            return null;
        }
        return UserConvertor.toEntity(userDB);
    }

    @Override
    public IPage<UserEntity> listByParamQuery(UserListByParamQuery query) {
        IPage<UserDB> userDBIPage = userMapper.listByParamQuery(new Page<UserEntity>(query.getPageIndex(), query.getPageSize()), query);

        return userDBIPage.convert(UserConvertor::toEntity);
    }
}
