package cn.j3code.ldwallet.api.feign;

import cn.j3code.ldwallet.api.feign.form.UpdateWalletForm;
import cn.j3code.ldwallet.api.feign.vo.WalletUpdateResultVO;
import cn.j3code.ldwallet.server.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.api.feign
 * @createTime 2022/12/29 - 23:04
 * @description
 */
@RestController
@RequestMapping("/v1/feign/wallet")
@AllArgsConstructor
public class WalletFeign {

    private final WalletService walletService;

    @PostMapping("/updateWallet")
    public WalletUpdateResultVO updateBalance(@RequestBody UpdateWalletForm form) {
        return walletService.updateBalance(form);
    }

    @PostMapping("/initUserWallet")
    public void initUserWallet(@RequestParam("userId") Long userId) {
        walletService.initUserWallet(userId);
    }

}
