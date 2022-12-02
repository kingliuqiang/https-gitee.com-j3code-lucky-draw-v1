package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IAwardService;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.AwardUpdateCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web.admin
 * @createTime 2022/12/2 - 23:22
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/award")
public class AdminAwardController {

    private final IAwardService awardService;

    @PostMapping("/add")
    public AwardVO add(@Validated @RequestBody AwardAddCmd cmd) {
        return awardService.add(cmd);
    }

    @PostMapping("/update")
    public AwardVO update(@Validated @RequestBody AwardUpdateCmd cmd) {
        return awardService.update(cmd);
    }

    @GetMapping("/{id}")
    public AwardVO one(@PathVariable(name = "id") Long id) {
        return awardService.one(id);
    }

    @PostMapping("/page")
    public IPage<AwardVO> page(@RequestBody AwardListByParamQuery query) {
        return awardService.page(query);
    }


}
