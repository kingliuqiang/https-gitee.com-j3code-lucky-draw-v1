package cn.j3code.luckyapp.assembler;

import cn.j3code.luckyclient.dto.UserRegisterCmd;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckydomain.user.PassWord;
import cn.j3code.luckydomain.user.UserEntity;
import cn.j3code.luckydomain.user.UserName;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.assembler
 * @createTime 2022/11/28 - 22:17
 * @description
 */
public class UserAssembler {
    public static UserEntity toAddEntity(UserRegisterCmd cmd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(new UserName(cmd.getUsername()));
        userEntity.setPassword(new PassWord(cmd.getPassword()));
        userEntity.setName(cmd.getName());
        userEntity.setPhone(cmd.getPhone());
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setUpdateTime(LocalDateTime.now());

        return userEntity;
    }

    public static UserVO toUserVO(UserEntity entity) {
        UserVO userVO = new UserVO();
        userVO.setId(entity.getId());
        userVO.setUsername(entity.getUsername().getUsername());
        userVO.setName(entity.getName());
        userVO.setPhone(entity.getPhone());
        userVO.setCreateTime(entity.getCreateTime());
        userVO.setUpdateTime(entity.getUpdateTime());

        return userVO;
    }
}
