package cn.j3code.luckyapp.award.query;

import cn.j3code.luckyapp.assembler.AwardAssembler;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckydomain.award.AwardEntity;
import cn.j3code.luckydomain.gateway.AwardGateway;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.award.query
 * @createTime 2022/12/2 - 22:47
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardListByParamQueryExe {
    private final AwardGateway awardGateway;

    public IPage<AwardVO> execute(AwardListByParamQuery query) {
        IPage<AwardEntity> page = awardGateway.page(query);

        return page.convert(AwardAssembler::toAwardVO);
    }
}
