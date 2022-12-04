package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.ActivityRuleListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityRuleDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【ld_activity_rule】的数据库操作Mapper
* @createDate 2022-12-04 22:57:07
* @Entity cn.j3code.lduser.po.ActivityRule
*/
public interface ActivityRuleMapper extends BaseMapper<ActivityRuleDB> {

    List<ActivityRuleDB> list(@Param("query") ActivityRuleListByParamQuery query);

    void deleteByActivityId(@Param("activityId") Long activityId);
}




