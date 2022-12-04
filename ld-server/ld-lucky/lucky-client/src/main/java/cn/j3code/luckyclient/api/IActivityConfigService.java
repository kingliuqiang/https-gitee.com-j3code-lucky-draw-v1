package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.ActivityConfigAddCmd;
import cn.j3code.luckyclient.dto.ActivityConfigUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityConfigVO;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/4 - 22:30
 * @description
 */
public interface IActivityConfigService {

    ActivityConfigVO add(ActivityConfigAddCmd cmd);

    ActivityConfigVO update(ActivityConfigUpdateCmd cmd);

    ActivityConfigVO one(Long id);

}
