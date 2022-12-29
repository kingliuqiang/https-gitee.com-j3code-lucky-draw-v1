package cn.j3code.luckyapp.record.query;

import cn.j3code.luckydomain.gateway.RecordGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.record.query
 * @createTime 2022/12/29 - 22:21
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class RecordMoneyParamQueryExe {
    private final RecordGateway recordGateway;

    public BigDecimal execute(Long recordId) {
        return recordGateway.getPrizeMoneyByRecordId(recordId);
    }
}
