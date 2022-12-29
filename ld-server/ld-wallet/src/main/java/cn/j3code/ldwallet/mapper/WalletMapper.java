package cn.j3code.ldwallet.mapper;

import cn.j3code.ldwallet.po.Wallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.mapper
 * @createTime 2022/12/29 - 23:00
 * @description
 */
public interface WalletMapper  extends BaseMapper<Wallet> {
    int updateBalance(@Param("userId") Long userId, @Param("updateMoney") BigDecimal updateMoney, @Param("balance") BigDecimal balance);

    List<Long> notInitUserList();
}
