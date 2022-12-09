package cn.j3code.luckyapp.record.command;

import cn.j3code.luckyapp.assembler.RecordAssembler;
import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckydomain.gateway.RecordGateway;
import cn.j3code.luckydomain.record.RecordEntity;
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
public class RecordAddCmdExe {

    private final RecordGateway recordGateway;

    public RecordVO execute(RecordAddCmd cmd) {
        RecordEntity entity = recordGateway.save(RecordAssembler.toAddEntity(cmd));

        return RecordAssembler.toRecordVO(entity);
    }
}
