package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.RuleListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RuleDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【bld_rule】的数据库操作Mapper
* @createDate 2022-12-01 23:20:02
* @Entity cn.j3code.lduser.po.Rule
*/
public interface RuleMapper extends BaseMapper<RuleDB> {

    IPage<RuleDB> page(@Param("ruleDBPage") Page<RuleDB> ruleDBPage, @Param("query") RuleListByParamQuery query);
}




