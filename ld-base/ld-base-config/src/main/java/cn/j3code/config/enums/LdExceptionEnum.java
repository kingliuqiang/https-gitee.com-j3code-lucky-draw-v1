package cn.j3code.config.enums;

import cn.j3code.config.vo.FailInfo;
import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.config
 * @createTime 2022/12/4 - 21:58
 * @description
 */
@Getter
public enum LdExceptionEnum {

    ADD_ERROR(FailInfo.DEFAULT_CODE, "保存数据失败！"),

    UPDATE_ERROR(FailInfo.DEFAULT_CODE, "保存数据失败！"),

    ;
    private Integer code;

    private String description;

    LdExceptionEnum(Integer code, String description){
        this.code = code;
        this.description = description;
    }

}
