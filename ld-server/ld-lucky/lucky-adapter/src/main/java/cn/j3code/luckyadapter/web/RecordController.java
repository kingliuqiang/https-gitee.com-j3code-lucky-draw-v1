package cn.j3code.luckyadapter.web;

import cn.j3code.common.annotation.ResponseResult;
import cn.j3code.config.util.SecurityUtil;
import cn.j3code.luckyclient.api.IRecordServer;
import cn.j3code.luckyclient.dto.RecordUpdateStatusCmd;
import cn.j3code.luckyclient.dto.data.RecordVO;
import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyadapter.web
 * @createTime 2022/12/12 - 22:11
 * @description
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RequestMapping("/v1/record")
public class RecordController {

    private final IRecordServer recordServer;

    @PostMapping("/page")
    public IPage<RecordVO> page(@RequestBody RecordListByParamQuery query) {
        query.setUserId(SecurityUtil.getUserId());
        return recordServer.page(query);
    }

    @GetMapping("/prizeType")
    public Integer prizeType(@RequestParam("recordId") Long recordId) {
        return recordServer.prizeType(recordId);
    }

    @GetMapping("/updateStatusTo4")
    public Boolean updateStatusTo4(RecordUpdateStatusCmd cmd) {
        cmd.setState(4);
        return recordServer.update(cmd);
    }


    @GetMapping("/exchangeMoney")
    public Boolean exchangeMoney(@RequestParam("recordId") Long recordId) {
        return recordServer.exchangeMoney(recordId);
    }




}
