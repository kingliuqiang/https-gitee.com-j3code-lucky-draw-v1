package cn.j3code.luckydomain.award;

import cn.j3code.config.exception.ldException;
import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.award
 * @createTime 2022/12/2 - 22:33
 * @description
 */
@Getter
public class AwardNumber {

    private Integer number;

    public AwardNumber(Integer number) {

        if (number < 0) {
            throw new ldException("奖项数量不合法，需大于等于 0");
        }

        this.number = number;
    }

}
