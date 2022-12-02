package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.luckyapp.prize.command.PrizeAddCmdExe;
import cn.j3code.luckyapp.prize.command.PrizeUpdateCmdExe;
import cn.j3code.luckyapp.prize.query.PrizeListByParamQueryExe;
import cn.j3code.luckyclient.api.IPrizeService;
import cn.j3code.luckyclient.dto.PrizeAddCmd;
import cn.j3code.luckyclient.dto.PrizeUpdateCmd;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/1 - 22:18
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class PrizeServiceImpl implements IPrizeService {

    private final PrizeAddCmdExe prizeAddCmdExe;
    private final PrizeUpdateCmdExe prizeUpdateCmdExe;
    private final PrizeListByParamQueryExe prizeListByParamQueryExe;

    @Override
    public PrizeVO add(PrizeAddCmd cmd) {
        return prizeAddCmdExe.execute(cmd);
    }

    @Override
    public PrizeVO update(PrizeUpdateCmd cmd) {
        return prizeUpdateCmdExe.execute(cmd);
    }

    @Override
    public IPage<PrizeVO> page(PrizeListByParamQuery query) {
        return prizeListByParamQueryExe.execute(query);
    }

    @Override
    public PrizeVO one(Long id) {
        final var query = new PrizeListByParamQuery();
        query.setId(id);
        IPage<PrizeVO> page = page(query);
        if (CollectionUtil.isEmpty(page.getRecords())) {
            return null;
        }

        return page.getRecords().get(0);
    }
}
