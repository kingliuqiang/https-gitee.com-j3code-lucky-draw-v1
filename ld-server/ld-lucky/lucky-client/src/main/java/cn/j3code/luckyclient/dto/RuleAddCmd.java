package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/12/1 - 23:26
 * @description
 */
@Data
public class RuleAddCmd extends Command {

    /**
     * 规则名称
     */
    @NotNull(message = "名称不为空")
    private String ruleName;

    /**
     * 最大可参与次数
     */
    @NotNull(message = "参与次数不为空")
    private Integer maxJoinNumber;

    /**
     * 最大可中奖次数
     */
    @NotNull(message = "中奖次数不为空")
    private Integer maxWinningNumber;
}
