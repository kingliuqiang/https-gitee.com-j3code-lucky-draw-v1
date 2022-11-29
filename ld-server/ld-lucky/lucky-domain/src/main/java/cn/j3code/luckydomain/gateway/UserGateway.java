package cn.j3code.luckydomain.gateway;

import cn.j3code.luckydomain.user.UserEntity;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.gateway
 * @createTime 2022/11/28 - 22:08
 * @description
 */
public interface UserGateway {

    UserEntity save(UserEntity entity);

    UserEntity findByUserName(Long id, String username);
}
