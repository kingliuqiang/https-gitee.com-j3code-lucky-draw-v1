package cn.j3code.luckyapp.activityrule.query;

import cn.hutool.core.collection.CollectionUtil;
import cn.j3code.luckyapp.assembler.ActivityRuleAssembler;
import cn.j3code.luckyclient.dto.data.ActivityRuleVO;
import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckydomain.activityrule.ActivityRuleEntity;
import cn.j3code.luckydomain.gateway.ActivityRuleGateway;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.activityrule.query
 * @createTime 2022/12/4 - 23:14
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityRuleListByParamQueryExe {

    private final ActivityRuleGateway activityRuleGateway;

    public List<ActivityRuleVO> execute(ActivityRuleListByParamQuery query) {
        List<ActivityRuleEntity> list = activityRuleGateway.list(query);

        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>();
        }

        return new Page<ActivityRuleEntity>()
                .setRecords(list)
                .convert(ActivityRuleAssembler::toActivityRuleVO)
                .getRecords();
    }
}
