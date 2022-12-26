package cn.j3code.luckyapp.service;

import cn.j3code.luckyapp.acceptprize.command.AcceptPrizeAddCmdExe;
import cn.j3code.luckyapp.acceptprize.query.AcceptPrizeOneExe;
import cn.j3code.luckyapp.record.command.RecordUpdateStatusCmdExe;
import cn.j3code.luckyclient.api.IAcceptPrizeService;
import cn.j3code.luckyclient.dto.AcceptPrizeAddCmd;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/26 - 23:08
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class AcceptPrizeServiceImpl implements IAcceptPrizeService {

    private final AcceptPrizeAddCmdExe acceptPrizeAddCmdExe;
    private final RecordUpdateStatusCmdExe recordUpdateStatusCmdExe;
    private final AcceptPrizeOneExe acceptPrizeOneExe;


    @Override
    public AcceptPrizeVO one(Long recordId) {
        return acceptPrizeOneExe.execute(recordId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AcceptPrizeVO add(AcceptPrizeAddCmd cmd) {

        AcceptPrizeVO execute = acceptPrizeAddCmdExe.execute(cmd);

        final var statusCmd = new RecordUpdateStatusCmd();
        statusCmd.setId(cmd.getRecordId());
        statusCmd.setState(2);
        recordUpdateStatusCmdExe.execute(statusCmd);

        return execute;
    }
}
