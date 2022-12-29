package cn.j3code.ldwallet.api.feign.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.api.feign.form
 * @createTime 2022/12/29 - 23:07
 * @description
 */
@Data
public class UpdateWalletForm {

    private Long userId;

    private BigDecimal updateMoney;
}
