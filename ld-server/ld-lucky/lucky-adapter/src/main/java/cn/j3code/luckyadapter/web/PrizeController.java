package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.luckyclient.api.IPrizeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/v1/prize")
public class PrizeController {

    private final IPrizeService prizeService;

}
