package cn.j3code.luckyinfrastructure.convertor;
import cn.j3code.luckydomain.user.PassWord;
import cn.j3code.luckydomain.user.UserEntity;
import cn.j3code.luckydomain.user.UserName;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.UserDB;

import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyinfrastructure.convertor
 * @createTime 2022/11/28 - 22:25
 * @description
 */
public class UserConvertor {

    public static UserDB toUserDB(UserEntity entity) {
        UserDB userDB = new UserDB();
        userDB.setId(entity.getId());
        userDB.setUsername(entity.getUsername().getUsername());

        if (Objects.nonNull(entity.getPassword())){
            userDB.setPassword(entity.getPassword().getEncryptionPassWord().getPassword());
        }
        userDB.setName(entity.getName());
        userDB.setPhone(entity.getPhone());
        userDB.setCreateTime(entity.getCreateTime());
        // 根据登入人的name值设置
        userDB.setCreator("三哥");
        userDB.setUpdateTime(entity.getCreateTime());
        userDB.setUpdater("三哥");

        return userDB;
    }

    public static UserEntity toEntity(UserDB userDB) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDB.getId());
        userEntity.setUsername(new UserName(userDB.getUsername()));

        userEntity.setPassword(new PassWord(new PassWord.EncryptionPassWord(userDB.getPassword())));

        userEntity.setName(userDB.getName());
        userEntity.setPhone(userDB.getPhone());
        userEntity.setCreateTime(userDB.getCreateTime());
        userEntity.setUpdateTime(userDB.getUpdateTime());

        return userEntity;
    }
}
