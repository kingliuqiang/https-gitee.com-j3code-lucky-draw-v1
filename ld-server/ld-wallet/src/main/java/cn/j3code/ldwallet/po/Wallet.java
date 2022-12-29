package cn.j3code.ldwallet.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.po
 * @createTime 2022/12/29 - 22:59
 * @description
 */
@Data
@TableName(value = "bld_user_wallet")
public class Wallet {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private BigDecimal balance;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String updater;
}
