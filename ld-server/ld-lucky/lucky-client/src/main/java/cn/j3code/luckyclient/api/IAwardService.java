package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.AwardAddCmd;
import cn.j3code.luckyclient.dto.AwardUpdateCmd;
import cn.j3code.luckyclient.dto.data.AwardVO;
import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/2 - 22:27
 * @description
 */
public interface IAwardService {

    AwardVO add(AwardAddCmd cmd);

    AwardVO update(AwardUpdateCmd cmd);

    AwardVO one(Long id);

    IPage<AwardVO> page(AwardListByParamQuery query);
}
