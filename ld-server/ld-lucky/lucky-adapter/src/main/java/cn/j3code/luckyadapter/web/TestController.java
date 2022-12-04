package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.exception.LdCodeException;
import cn.j3code.config.util.AssertUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web
 * @createTime 2022/12/4 - 22:19
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/test")
public class TestController {

    @GetMapping("/errorTest01")
    public void errorTest01(){
        throw new LdCodeException(5050, "测试错误！");
    }

    @GetMapping("/errorTest02")
    public void errorTest02(){
        AssertUtil.isTrue(Boolean.TRUE, LdExceptionEnum.ADD_ERROR.getDescription());
    }

}
