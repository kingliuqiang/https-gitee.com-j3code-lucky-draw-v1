package cn.j3code.luckyadapter.scheduled;

import cn.j3code.common.annotation.DistributedLock;
import cn.j3code.luckyapp.activity.command.RedisDeductionAwardNumberDrawExe;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.scheduled
 * @createTime 2022/12/9 - 22:45
 * @description
 */
@Component
@Slf4j
@AllArgsConstructor
public class RecordStatusScheduled {

    private final RedisDeductionAwardNumberDrawExe drawExe;


    /**
     * 每个5分钟执行一次
     */
    @DistributedLock
    @Scheduled(cron = "0 0/5 * * * ?")
    public void deductionOfInventoryAndUpdateRecordStatus() {
        /**
         * 定时扫描用户不可见状态的中奖记录，然后对比当前时间和数据创建时间，
         * 发现两者相隔 10 分钟，那么，定时任务就可以把这个记录查询出来，再来执行一边，方案三消费者流程
         */
        drawExe.ScheduledExecuteDeductionOfInventoryAndUpdateRecordStatus();
    }


    @DistributedLock(key = "test")
    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {

        try {
            System.out.println("业务处理中");
            Thread.sleep(1 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
