package cn.j3code.ldwallet.server;

import cn.j3code.ldwallet.api.feign.form.UpdateWalletForm;
import cn.j3code.ldwallet.api.feign.vo.WalletUpdateResultVO;
import cn.j3code.ldwallet.po.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.server
 * @createTime 2022/12/29 - 23:01
 * @description
 */
public interface WalletService  extends IService<Wallet> {
    WalletUpdateResultVO updateBalance(UpdateWalletForm form);

    void initUserWallet(Long userId);

    void initAllNotWalletUser();

}
