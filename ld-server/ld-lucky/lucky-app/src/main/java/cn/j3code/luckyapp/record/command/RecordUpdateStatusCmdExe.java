package cn.j3code.luckyapp.record.command;

import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckydomain.gateway.RecordGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.record.command
 * @createTime 2022/12/9 - 23:27
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class RecordUpdateStatusCmdExe {

    private final RecordGateway recordGateway;

    public Boolean execute(RecordUpdateStatusCmd cmd) {
        Boolean updateStatus = recordGateway.updateStatus(cmd.getId(), cmd.getState());

        log.info("修改记录失败：记录id：{}，状态值：{}", cmd.getId(), cmd.getState());
        return updateStatus;
    }
}
