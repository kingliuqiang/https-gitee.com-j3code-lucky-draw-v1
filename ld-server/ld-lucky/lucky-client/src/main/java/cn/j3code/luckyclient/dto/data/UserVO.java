package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.data
 * @createTime 2022/11/26 - 23:39
 * @description
 */
@Data
public class UserVO {
    /**
     *
     */
    private Long id;

    /**
     * 账号
     */
    private String username;


    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private LocalDateTime updateTime;
}
