package cn.j3code.luckyadapter.web.admin;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IPrizeService;
import cn.j3code.luckyclient.dto.PrizeAddCmd;
import cn.j3code.luckyclient.dto.PrizeUpdateCmd;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web
 * @createTime 2022/12/1 - 22:51
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/admin/v1/prize")
public class AdminPrizeController {

    private final IPrizeService prizeService;

    @PostMapping("/add")
    public PrizeVO add(@Validated @RequestBody PrizeAddCmd cmd) {
        return prizeService.add(cmd);
    }

    @PostMapping("/update")
    public PrizeVO update(@Validated @RequestBody PrizeUpdateCmd cmd) {
        return prizeService.update(cmd);
    }

    @PostMapping("/page")
    public IPage<PrizeVO> page(@RequestBody PrizeListByParamQuery query) {
        return prizeService.page(query);
    }

    @PostMapping("/{id}")
    public PrizeVO one(@PathVariable(name = "id") Long id) {
        return prizeService.one(id);
    }

}
