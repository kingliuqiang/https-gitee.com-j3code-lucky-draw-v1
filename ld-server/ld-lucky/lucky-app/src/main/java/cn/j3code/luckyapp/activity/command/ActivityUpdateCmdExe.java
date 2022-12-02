package cn.j3code.luckyapp.activity.command;

import cn.j3code.luckyapp.assembler.ActivityAssembler;
import cn.j3code.luckyclient.dto.ActivityUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckydomain.activity.ActivityEntity;
import cn.j3code.luckydomain.gateway.ActivityGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activity.command
 * @createTime 2022/12/2 - 23:58
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityUpdateCmdExe {

    private final ActivityGateway activityGateway;

    public ActivityVO execute(ActivityUpdateCmd cmd) {
        ActivityEntity entity = activityGateway.save(ActivityAssembler.toUpdateEntity(cmd));

        return ActivityAssembler.toActivityVO(entity);
    }
}
