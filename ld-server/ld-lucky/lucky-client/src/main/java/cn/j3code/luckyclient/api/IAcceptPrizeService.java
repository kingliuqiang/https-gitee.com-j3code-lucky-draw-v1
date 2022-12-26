package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.AcceptPrizeAddCmd;
import cn.j3code.luckyclient.dto.data.AcceptPrizeVO;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/26 - 23:01
 * @description
 */
public interface IAcceptPrizeService {

    AcceptPrizeVO one(Long recordId);

    AcceptPrizeVO add(AcceptPrizeAddCmd cmd);
}
