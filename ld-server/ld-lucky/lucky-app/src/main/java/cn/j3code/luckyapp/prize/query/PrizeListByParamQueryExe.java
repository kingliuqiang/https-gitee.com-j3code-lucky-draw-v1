package cn.j3code.luckyapp.prize.query;

import cn.j3code.luckyapp.assembler.PrizeAssembler;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import cn.j3code.luckydomain.gateway.PrizeGateway;
import cn.j3code.luckydomain.prize.PrizeEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.prize.query
 * @createTime 2022/12/1 - 22:21
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeListByParamQueryExe {

    private final PrizeGateway prizeGateway;

    public IPage<PrizeVO> execute(PrizeListByParamQuery query) {
        IPage<PrizeEntity> page = prizeGateway.page(query);

        return page.convert(PrizeAssembler::toPrizeVO);
    }
}
