package cn.j3code.luckydomain.rule;

import cn.j3code.config.exception.ldException;
import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.rule
 * @createTime 2022/12/1 - 23:23
 * @description
 */
@Getter
public class MinNumber {

    private Integer number;

    public MinNumber(Integer number){
        if (number < 1){
            throw new ldException("规则次数必须大于等于 1");
        }

        this.number = number;
    }

}
