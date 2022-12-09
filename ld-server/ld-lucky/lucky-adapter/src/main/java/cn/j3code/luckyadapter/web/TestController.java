package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.config.enums.LdExceptionEnum;
import cn.j3code.config.exception.LdCodeException;
import cn.j3code.config.util.AssertUtil;
import cn.j3code.luckyapp.activity.command.RedisDeductionAwardNumberDrawExe;
import cn.j3code.luckyapp.context.ActivityDrawContext;
import cn.j3code.luckyapp.listener.AwardInventoryToRedisApplicationListener;
import cn.j3code.luckyapp.listener.event.ActivityCreateEvent;
import cn.j3code.luckyapp.mq.producer.ActivityDrawMessageProducer;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.data.AwardVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    private final ApplicationEventMulticaster applicationEventMulticaster;

    private final RedisDeductionAwardNumberDrawExe drawExe;

    private final ActivityDrawMessageProducer activityDrawMessageProducer;

    @GetMapping("/errorTest01")
    public void errorTest01() {
        throw new LdCodeException(5050, "测试错误！");
    }

    @GetMapping("/errorTest02")
    public void errorTest02() {
        AssertUtil.isTrue(Boolean.TRUE, LdExceptionEnum.ADD_ERROR.getDescription());
    }

    @GetMapping("/activityCreateEventTest")
    public void activityCreateEventTest() {

        ActivityConfigVO activityConfigVO = new ActivityConfigVO();

        ActivityVO activityVO = new ActivityVO();
        activityVO.setId(1L);
        activityConfigVO.setActivityVO(activityVO);


        List<AwardVO> awardVOList = new ArrayList<>();
        AwardVO awardVO = new AwardVO();
        awardVO.setAwardName("测试奖项");
        awardVO.setId(100L);
        awardVO.setPrizeId(1L);
        awardVO.setNumber(200);
        awardVOList.add(awardVO);


        AwardVO awardVO2 = new AwardVO();
        awardVO2.setAwardName("测试奖项");
        awardVO2.setId(200L);
        awardVO2.setPrizeId(1L);
        awardVO2.setNumber(400);
        awardVOList.add(awardVO2);
        activityConfigVO.setAwardVOList(awardVOList);
        // 发送活动创建事件
        applicationEventMulticaster.multicastEvent(new ActivityCreateEvent("", activityConfigVO));
    }


    @GetMapping("/invokeStockDeductionLuaTest")
    public Integer invokeStockDeductionLuaTest() {
        return drawExe.invokeStockDeductionLua(
                AwardInventoryToRedisApplicationListener.getKey(1L, 100L));
    }

    @GetMapping("/invokeStockRollbackLuaTest")
    public Integer invokeStockRollbackLuaTest() {
        return drawExe.invokeStockRollbackLua(
                AwardInventoryToRedisApplicationListener.getKey(1L, 100L));
    }

    @GetMapping("/activityDrawMessageProducerTest")
    public Boolean activityDrawMessageProducerTest() {
        return activityDrawMessageProducer.send(new ActivityDrawContext());
    }
}
