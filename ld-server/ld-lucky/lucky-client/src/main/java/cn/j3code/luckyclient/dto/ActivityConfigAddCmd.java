package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/12/4 - 22:31
 * @description
 */
@Data
public class ActivityConfigAddCmd extends Command {

    private ActivityAddCmd activityAddCmd;

    private List<Long> ruleIdList;

    private List<AwardAddCmd> awardAddCmdList;
}
