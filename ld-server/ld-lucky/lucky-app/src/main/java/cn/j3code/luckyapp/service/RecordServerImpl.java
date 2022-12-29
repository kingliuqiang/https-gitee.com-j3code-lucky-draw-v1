package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollUtil;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyapp.record.command.RecordAddCmdExe;
import cn.j3code.luckyapp.record.command.RecordUpdateStatusCmdExe;
import cn.j3code.luckyapp.record.query.RecordListByParamQueryExe;
import cn.j3code.luckyapp.record.query.RecordMoneyParamQueryExe;
import cn.j3code.luckyclient.api.IRecordServer;
import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckyclient.feign.WalletFeignApi;
import cn.j3code.luckyclient.feign.form.UpdateWalletForm;
import cn.j3code.luckyclient.feign.vo.WalletUpdateResultVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/9 - 23:26
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class RecordServerImpl implements IRecordServer {

    private final RecordAddCmdExe recordAddCmdExe;
    private final RecordUpdateStatusCmdExe recordUpdateStatusCmdExe;
    private final RecordListByParamQueryExe recordListByParamQueryExe;
    private final RecordMoneyParamQueryExe recordMoneyParamQueryExe;

    private final WalletFeignApi walletFeignApi;


    @Override
    public IPage<RecordVO> page(RecordListByParamQuery query) {
        return recordListByParamQueryExe.execute(query);
    }

    @Override
    public RecordVO add(RecordAddCmd cmd) {
        return recordAddCmdExe.execute(cmd);
    }

    @Override
    public Boolean update(RecordUpdateStatusCmd cmd) {
        return recordUpdateStatusCmdExe.execute(cmd);
    }

    @Override
    public Integer prizeType(Long recordId) {
        return getPrizeByRecordId(recordId).getPrizeType();
    }

    public RecordVO getPrizeByRecordId(Long recordId) {
        final var recordQuery = new RecordListByParamQuery();
        recordQuery.setRecordId(recordId);

        List<RecordVO> recordVOList = recordListByParamQueryExe.execute(recordQuery).getRecords();
        AssertUtil.isTrue(CollUtil.isEmpty(recordVOList) || Objects.isNull(recordVOList.get(0)), "数据不存在！");

        return recordVOList.get(0);
    }


    @Override
    public Boolean exchangeMoney(Long recordId) {
        AssertUtil.isTrue(prizeType(recordId) != 2, "奖品类型兑换出错！");
        // 获取奖品金额
        BigDecimal money = recordMoneyParamQueryExe.execute(recordId);

        // 将记录状态改为，4
        final var statusCmd = new RecordUpdateStatusCmd();
        statusCmd.setId(recordId);
        statusCmd.setState(4);
        update(statusCmd);

        try {
            // TODO: 调用给用户钱包价钱逻辑
            final var walletForm = new UpdateWalletForm();
            walletForm.setUpdateMoney(money.multiply(new BigDecimal("-1")));
            walletForm.setUserId(SecurityUtil.getUserId());
            WalletUpdateResultVO walletUpdateResultVO = walletFeignApi.updateBalance(walletForm);

            if (Boolean.FALSE.equals(walletUpdateResultVO.getResult())) {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            //错误处理
            log.error("调用修改用户钱包金额失败：", e);

            // 回滚记录状态
            statusCmd.setState(1);
            update(statusCmd);

            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
