package cn.j3code.luckydomain.user;

import cn.hutool.crypto.digest.MD5;
import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.user
 * @createTime 2022/11/26 - 23:23
 * @description
 */
@Getter
public class PassWord {

    private EncryptionPassWord encryptionPassWord;

    public PassWord(String password) {
        this.encryptionPassWord = new EncryptionPassWord(getEncryptionPassWord(password));
    }

    private String getEncryptionPassWord(String password) {
        return MD5.create().digestHex(password);
    }

    @Getter
    public static class EncryptionPassWord {

        private String password;

        public EncryptionPassWord(String password) {
            this.password = password;
        }
    }

    /**
     * 判断密码相等
     * @param password
     * @return
     */
    public Boolean isEqual(String password) {
        return this.encryptionPassWord.password.equals(getEncryptionPassWord(password));
    }
}
