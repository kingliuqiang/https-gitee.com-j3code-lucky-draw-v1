package cn.j3code.luckyadapter.web.admin;

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
@RequestMapping("/admin/v1/record")
public class AdminRecordController {

    private final IRecordServer recordServer;

    @PostMapping("/page")
    public IPage<RecordVO> page(@RequestBody RecordListByParamQuery query) {
        query.setUserId(SecurityUtil.getUserId());
        return recordServer.page(query);
    }

    @GetMapping("/updateStatusTo3")
    public Boolean updateStatusTo3(RecordUpdateStatusCmd cmd) {
        cmd.setState(3);
        return recordServer.update(cmd);
    }

}
