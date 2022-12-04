package cn.j3code.luckydomain.prize;

import cn.j3code.config.exception.LdException;
import lombok.Getter;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.prize
 * @createTime 2022/12/1 - 22:06
 * @description
 */
@Getter
public class Tnventory {

    private Integer inventory;

    public Tnventory(Integer inventory) {
        if (inventory < 0) {
            throw new LdException("库存数量请大于等于 0");
        }
        this.inventory = inventory;
    }


}
