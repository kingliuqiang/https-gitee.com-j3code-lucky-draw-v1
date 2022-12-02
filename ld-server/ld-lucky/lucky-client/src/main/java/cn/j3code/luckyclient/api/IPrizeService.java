package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.PrizeAddCmd;
import cn.j3code.luckyclient.dto.PrizeUpdateCmd;
import cn.j3code.luckyclient.dto.data.PrizeVO;
import cn.j3code.luckyclient.dto.query.PrizeListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/1 - 22:09
 * @description
 */
public interface IPrizeService {

    /**
     * 添加
     * @param cmd
     * @return
     */
    PrizeVO add(PrizeAddCmd cmd);

    /**
     * 修改
     * @param cmd
     * @return
     */
    PrizeVO update(PrizeUpdateCmd cmd);

    /**
     * 查询
     * @param query
     * @return
     */
    IPage<PrizeVO> page(PrizeListByParamQuery query);

    /**
     * 查询
     * @param id
     * @return
     */
    PrizeVO one(Long id);
}
