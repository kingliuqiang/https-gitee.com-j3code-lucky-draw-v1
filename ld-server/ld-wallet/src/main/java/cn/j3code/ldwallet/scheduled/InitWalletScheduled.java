package cn.j3code.ldwallet.scheduled;

import cn.j3code.common.annotation.DistributedLock;
import cn.j3code.ldwallet.server.WalletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.scheduled
 * @createTime 2022/12/29 - 23:38
 * @description
 */
@Component
@AllArgsConstructor
@Slf4j
public class InitWalletScheduled {

    private final WalletService walletService;


    @DistributedLock
    @Scheduled(cron = "0 0 0/1 * * ?")
    void initWallet(){
        walletService.initAllNotWalletUser();
    }

}
