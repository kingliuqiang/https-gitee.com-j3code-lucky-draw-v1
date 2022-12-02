package cn.j3code.luckyapp.rule.command;

import cn.j3code.luckyapp.assembler.RuleAssembler;
import cn.j3code.luckyclient.dto.RuleAddCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckydomain.gateway.RuleGateway;
import cn.j3code.luckydomain.rule.RuleEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.rule.command
 * @createTime 2022/12/1 - 23:32
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class RuleAddCmdExe {

    private final RuleGateway ruleGateway;

    public RuleVO execute(RuleAddCmd cmd) {
        RuleEntity save = ruleGateway.save(RuleAssembler.toAddEntity(cmd));

        return RuleAssembler.toRuleVO(save);
    }
}
