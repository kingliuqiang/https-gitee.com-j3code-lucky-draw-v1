package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.AwardListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AwardDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【bld_award】的数据库操作Mapper
* @createDate 2022-11-26 23:02:09
* @Entity cn.j3code.lduser.po.Award
*/
public interface AwardMapper extends BaseMapper<AwardDB> {

    IPage<AwardDB> page(@Param("awardDBPage") Page<AwardDB> awardDBPage, @Param("query") AwardListByParamQuery query);

    int deductionAwardNumber(@Param("awardId") Long awardId, @Param("number") Integer number);
}




