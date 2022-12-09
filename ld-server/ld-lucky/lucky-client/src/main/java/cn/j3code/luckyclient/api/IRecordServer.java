package cn.j3code.luckyclient.api;

import cn.j3code.luckyclient.dto.RecordAddCmd;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.api
 * @createTime 2022/12/9 - 23:24
 * @description
 */
public interface IRecordServer {

    IPage<RecordVO> page(RecordListByParamQuery query);

    RecordVO add(RecordAddCmd cmd);

    Boolean update(RecordUpdateStatusCmd cmd);
}
