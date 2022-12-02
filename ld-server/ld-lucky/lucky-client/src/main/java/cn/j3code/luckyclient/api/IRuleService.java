package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.RuleAddCmd;
import cn.j3code.luckyclient.dto.RuleUpdateCmd;
import cn.j3code.luckyclient.dto.data.RuleVO;
import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/1 - 23:30
 * @description
 */
public interface IRuleService {

    RuleVO add(RuleAddCmd cmd);

    RuleVO update(RuleUpdateCmd cmd);

    RuleVO one(Long id);

    IPage<RuleVO> page(RuleListByParamQuery query);

}
