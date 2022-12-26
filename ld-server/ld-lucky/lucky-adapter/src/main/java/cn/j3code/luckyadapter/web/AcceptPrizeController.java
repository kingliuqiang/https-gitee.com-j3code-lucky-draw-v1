package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IAcceptPrizeService;
import cn.j3code.luckyclient.dto.AcceptPrizeAddCmd;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web
 * @createTime 2022/12/26 - 23:30
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/acceptPrize")
public class AcceptPrizeController {

    private final IAcceptPrizeService acceptPrizeService;


    @PostMapping("/add")
    public AcceptPrizeVO add(@Validated @RequestBody AcceptPrizeAddCmd cmd) {
        return acceptPrizeService.add(cmd);
    }

    @GetMapping("/one")
    public AcceptPrizeVO one(@RequestParam("recordId") Long recordId) {
        return acceptPrizeService.one(recordId);
    }

}
