package cn.j3code.luckyapp.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyapp.activity.command.ActivityAddCmdExe;
import cn.j3code.luckyapp.activity.command.ActivityUpdateCmdExe;
import cn.j3code.luckyapp.activity.command.RedisDeductionAwardNumberDrawExe;
import cn.j3code.luckyapp.activity.query.ActivityListByParamQueryExe;
import cn.j3code.luckyclient.api.IActivityConfigService;
import cn.j3code.luckyclient.api.IActivityService;
import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.ActivityUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.DrawResultVO;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.service
 * @createTime 2022/12/2 - 23:57
 * @description
 */
@Slf4j
@Service
@AllArgsConstructor
public class ActivityServiceImpl implements IActivityService {

    private final ActivityAddCmdExe activityAddCmdExe;
    private final ActivityUpdateCmdExe activityUpdateCmdExe;
    private final ActivityListByParamQueryExe activityListByParamQueryExe;

    private final RedisDeductionAwardNumberDrawExe drawExe;

    private final IActivityConfigService activityConfigService;


    @Override
    public ActivityVO add(ActivityAddCmd cmd) {
        return activityAddCmdExe.execute(cmd);
    }

    @Override
    public ActivityVO update(ActivityUpdateCmd cmd) {
        return activityUpdateCmdExe.execute(cmd);
    }

    @Override
    public IPage<ActivityVO> page(ActivityListByParamQuery query) {
        return activityListByParamQueryExe.execute(query);
    }

    @Override
    public ActivityVO one(Long id) {
        final var query = new ActivityListByParamQuery();
        query.setId(id);
        IPage<ActivityVO> page = page(query);

        if (CollectionUtil.isEmpty(page.getRecords())) {
            return null;
        }

        return page.getRecords().get(0);
    }

    @Override
    public DrawResultVO draw(Long activityId) {
        log.info("用户：{}，开始抽奖...", SecurityUtil.getName());
        return drawExe.execute(activityConfigService.one(activityId));
    }
}
