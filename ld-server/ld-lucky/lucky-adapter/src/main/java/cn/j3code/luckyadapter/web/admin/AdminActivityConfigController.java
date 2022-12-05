package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IActivityConfigService;
import cn.j3code.luckyclient.dto.ActivityConfigAddCmd;
import cn.j3code.luckyclient.dto.data.ActivityConfigCopyVO;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web.admin
 * @createTime 2022/12/5 - 22:03
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/activityConfig")
public class AdminActivityConfigController {

    private final IActivityConfigService activityConfigService;

    @PostMapping("/add")
    public ActivityConfigVO add(@Validated @RequestBody ActivityConfigAddCmd cmd){
        return activityConfigService.add(cmd);
    }

    @GetMapping("/one")
    public ActivityConfigVO one(@RequestParam("id") Long id){
        return activityConfigService.one(id);
    }

    @GetMapping("/copy")
    public ActivityConfigCopyVO copy(@RequestParam("id") Long id){
        return activityConfigService.copy(id);
    }
}
