package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/12/26 - 23:03
 * @description
 */
@Data
public class AcceptPrizeAddCmd extends Command {

    @NotNull(message = "抽奖记录Id不为空")
    private Long recordId;

    /**
     * 电话
     */
    @NotNull(message = "电话不为空")
    private String phone;

    /**
     * 地址
     */
    @NotNull(message = "地址不为空")
    private String address;
}
