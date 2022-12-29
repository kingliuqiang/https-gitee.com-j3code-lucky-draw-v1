package cn.j3code.luckyclient.feign;

import cn.j3code.luckyclient.feign.form.UpdateWalletForm;
import cn.j3code.luckyclient.feign.vo.WalletUpdateResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.feign
 * @createTime 2022/12/29 - 23:24
 * @description
 */
@FeignClient(name = "ld-wallet")
public interface WalletFeignApi {

    @PostMapping("/v1/feign/wallet/updateWallet")
    WalletUpdateResultVO updateBalance(@RequestBody UpdateWalletForm form);

    @GetMapping("/v1/feign/wallet/initUserWallet")
    void initUserWallet(Long userId);

}
