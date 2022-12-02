package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.ActivityAddCmd;
import cn.j3code.luckyclient.dto.ActivityUpdateCmd;
import cn.j3code.luckyclient.dto.data.ActivityVO;
import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/2 - 23:50
 * @description
 */
public interface IActivityService {

    ActivityVO add(ActivityAddCmd cmd);

    ActivityVO update(ActivityUpdateCmd cmd);


    IPage<ActivityVO> page(ActivityListByParamQuery query);

    ActivityVO one(Long id);
}
