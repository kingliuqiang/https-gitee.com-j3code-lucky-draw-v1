package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyclient.dto.query.RecordListByParamQuery;
import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.RecordDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
* @author Administrator
* @description 针对表【bld_record】的数据库操作Mapper
* @createDate 2022-11-26 23:01:54
* @Entity cn.j3code.lduser.po.Record
*/
public interface RecordMapper extends BaseMapper<RecordDB> {

    IPage<RecordDB> page(@Param("recordDBPage") Page<RecordDB> recordDBPage, @Param("query") RecordListByParamQuery query);

    Integer updateStatus(@Param("id") Long id, @Param("status") Integer status);

    BigDecimal getPrizeMoneyByRecordId(@Param("recordId") Long recordId);
}




