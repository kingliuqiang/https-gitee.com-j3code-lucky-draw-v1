package cn.j3code.luckydomain.activity;

import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.activity
 * @createTime 2022/12/2 - 23:43
 * @description
 */
@Getter
public enum ActivityStatusEnum {

    NOT_START(0, "未开始"),

    START(1, "进行中"),

    END(2, "已结束"),

    ;

    private Integer value;

    private String description;

    ActivityStatusEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
