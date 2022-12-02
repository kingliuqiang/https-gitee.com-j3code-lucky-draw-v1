package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.ActivityListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.ActivityDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【bld_activity】的数据库操作Mapper
* @createDate 2022-11-26 23:02:19
* @Entity cn.j3code.lduser.po.Activity
*/
public interface ActivityMapper extends BaseMapper<ActivityDB> {

    IPage<ActivityDB> page(@Param("activityDBPage") Page<ActivityDB> activityDBPage, @Param("query") ActivityListByParamQuery query);
}




