package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.luckyclient.api.IAwardService;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.AwardUpdateCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.j3code.luckyapp.award.command.AwardAddCmdExe;
import cn.j3code.luckyapp.award.command.AwardUpdateCmdExe;
import cn.j3code.luckyapp.award.query.AwardListByParamQueryExe;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/2 - 22:40
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class AwardServiceImpl implements IAwardService {

    private final AwardAddCmdExe awardAddCmdExe;
    private final AwardUpdateCmdExe awardUpdateCmdExe;
    private final AwardListByParamQueryExe awardListByParamQueryExe;

    @Override
    public AwardVO add(AwardAddCmd cmd) {
        return awardAddCmdExe.execute(cmd);
    }

    @Override
    public AwardVO update(AwardUpdateCmd cmd) {
        return awardUpdateCmdExe.execute(cmd);
    }

    @Override
    public AwardVO one(Long id) {
        final var query = new AwardListByParamQuery();
        query.setId(id);
        IPage<AwardVO> page = page(query);

        if (CollectionUtil.isEmpty(page.getRecords())) {
            return null;
        }

        return page.getRecords().get(0);
    }

    @Override
    public IPage<AwardVO> page(AwardListByParamQuery query) {
        return awardListByParamQueryExe.execute(query);
    }
}
