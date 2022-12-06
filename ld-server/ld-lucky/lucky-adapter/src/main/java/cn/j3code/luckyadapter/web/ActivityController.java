package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IActivityConfigService;
import cn.j3code.luckyclient.api.IActivityService;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.DrawResultVO;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web
 * @createTime 2022/12/6 - 22:47
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/activity")
public class ActivityController {

    private final IActivityConfigService activityConfigService;
    private final IActivityService activityService;


    @PostMapping("/page")
    public IPage<ActivityVO> page(@RequestBody ActivityListByParamQuery query) {
        return activityService.page(query);
    }

    @GetMapping("/one")
    public ActivityConfigVO one(@RequestParam("id") Long id) {
        return activityConfigService.one(id);
    }


    @GetMapping("/draw")
    public DrawResultVO draw(@RequestParam("activityId") Long activityId) {
        return activityService.draw(activityId);
    }

}
