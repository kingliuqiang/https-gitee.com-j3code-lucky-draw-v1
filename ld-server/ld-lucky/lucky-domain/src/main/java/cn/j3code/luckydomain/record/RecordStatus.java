package cn.j3code.luckydomain.record;

import cn.j3code.config.enums.RecordStatusEnum;
import cn.j3code.config.util.AssertUtil;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.record
 * @createTime 2022/12/9 - 23:06
 * @description
 */
public class RecordStatus {

    /**
     * 状态（0，1，2，3）
     */
    private RecordStatusEnum state;

    public Integer getState(){
        return this.state.getValue();
    }


    public RecordStatus(Integer state) {
        AssertUtil.isTrue(state < 0, "记录状态无效！");

        if (RecordStatusEnum.STATUE_0.getValue() == state){
            this.state = RecordStatusEnum.STATUE_1;
            return;
        }

        if (RecordStatusEnum.STATUE_1.getValue() == state){
            this.state = RecordStatusEnum.STATUE_1;
            return;
        }

        if (RecordStatusEnum.STATUE_2.getValue() == state){
            this.state = RecordStatusEnum.STATUE_2;
            return;
        }

        if (RecordStatusEnum.STATUE_3.getValue() == state){
            this.state = RecordStatusEnum.STATUE_3;
            return;
        }

        if (RecordStatusEnum.STATUE_4.getValue() == state){
            this.state = RecordStatusEnum.STATUE_4;
            return;
        }

        AssertUtil.isTrue(true, "记录状态无效！");
    }


}
