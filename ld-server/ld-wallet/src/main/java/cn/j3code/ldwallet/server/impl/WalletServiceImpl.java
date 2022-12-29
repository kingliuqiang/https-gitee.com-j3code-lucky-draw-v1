package cn.j3code.ldwallet.server.impl;

import cn.j3code.config.util.SecurityUtil;
import cn.j3code.ldwallet.api.feign.form.UpdateWalletForm;
import cn.j3code.ldwallet.api.feign.vo.WalletUpdateResultVO;
import cn.j3code.ldwallet.mapper.WalletMapper;
import cn.j3code.ldwallet.po.Wallet;
import cn.j3code.ldwallet.server.WalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.ldwallet.server.impl
 * @createTime 2022/12/29 - 23:02
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet>
        implements WalletService {


    @Override
    public WalletUpdateResultVO updateBalance(UpdateWalletForm form) {
        Wallet wallet = lambdaQuery()
                .eq(Wallet::getUserId, form.getUserId())
                .one();

        if (Objects.isNull(wallet)) {
            // 初始化用户钱包
            try {
                wallet = initWallet(form.getUserId());
            } catch (Exception e) {
                //错误处理
                log.error("执行初始化用户钱包失败：", e);
                wallet = lambdaQuery()
                        .eq(Wallet::getUserId, form.getUserId())
                        .one();
            }
        }

        if (Objects.isNull(wallet)) {
            return new WalletUpdateResultVO()
                    .setResult(Boolean.FALSE);
        }

        int updateBalance = getBaseMapper().updateBalance(form.getUserId(), form.getUpdateMoney(), wallet.getBalance());

        if (updateBalance != 1) {
            return new WalletUpdateResultVO()
                    .setResult(Boolean.FALSE);
        }

        return new WalletUpdateResultVO()
                .setResult(Boolean.TRUE);
    }

    @Override
    public void initUserWallet(Long userId) {
        initWallet(userId);
    }


    private Wallet initWallet(Long userId) {
        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        wallet.setBalance(new BigDecimal("0"));
        wallet.setCreateTime(LocalDateTime.now());
        wallet.setUpdateTime(LocalDateTime.now());
        wallet.setUpdater(SecurityUtil.getUserName());
        save(wallet);

        return wallet;
    }


    @Override
    public void initAllNotWalletUser() {
        List<Long> notInitUserList = getBaseMapper().notInitUserList();

        notInitUserList.stream().parallel().forEach(this::initWallet);
    }
}
