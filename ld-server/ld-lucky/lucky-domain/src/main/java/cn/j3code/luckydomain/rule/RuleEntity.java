package cn.j3code.luckydomain.rule;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.rule
 * @createTime 2022/12/1 - 23:21
 * @description
 */
@Entity
@Data
public class RuleEntity {

    /**
     *
     */
    private Long id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 最大可参与次数
     */
    private MinNumber maxJoinNumber;

    /**
     * 最大可中奖次数
     */
    private MinNumber maxWinningNumber;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private String creator;

    /**
     *
     */
    private LocalDateTime updateTime;

    /**
     *
     */
    private String updater;


}
