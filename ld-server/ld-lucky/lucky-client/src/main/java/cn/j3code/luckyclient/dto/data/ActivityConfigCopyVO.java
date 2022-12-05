package cn.j3code.luckyclient.dto.data;

import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.AwardAddCmd;
import lombok.Data;

import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.data
 * @createTime 2022/12/5 - 23:18
 * @description
 */
@Data
public class ActivityConfigCopyVO {
    private ActivityAddCmd activityAddCmd;

    private List<Long> ruleIdList;

    private List<AwardAddCmd> awardAddCmdList;
}
