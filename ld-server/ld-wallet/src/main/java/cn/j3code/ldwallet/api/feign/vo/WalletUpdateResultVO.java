package cn.j3code.ldwallet.api.feign.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.api.feign.vo
 * @createTime 2022/12/29 - 23:06
 * @description
 */
@Data
@Accessors(chain = true)
public class WalletUpdateResultVO {

    private Boolean result;

}
