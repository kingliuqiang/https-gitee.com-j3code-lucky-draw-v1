package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IRuleService;
import cn.j3code.luckyclient.dto.RuleAddCmd;
import cn.j3code.luckyclient.dto.RuleUpdateCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web.admin
 * @createTime 2022/12/1 - 23:51
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/rule")
public class AdminRuleController {

    private final IRuleService ruleService;

    @PostMapping("/add")
    public RuleVO add(@Validated @RequestBody RuleAddCmd cmd) {
        return ruleService.add(cmd);
    }

    @PostMapping("/update")
    public RuleVO update(@Validated @RequestBody RuleUpdateCmd cmd) {
        return ruleService.update(cmd);
    }

    @PostMapping("/page")
    public IPage<RuleVO> page(@RequestBody RuleListByParamQuery query) {
        return ruleService.page(query);
    }

    @GetMapping("/{id}")
    public RuleVO one(@PathVariable(name = "id") Long id) {
        return ruleService.one(id);
    }
}
