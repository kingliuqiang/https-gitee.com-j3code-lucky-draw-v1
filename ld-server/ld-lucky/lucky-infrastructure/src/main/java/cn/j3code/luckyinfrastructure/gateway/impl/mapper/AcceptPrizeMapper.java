package cn.j3code.luckyinfrastructure.gateway.impl.mapper;

import cn.j3code.luckyinfrastructure.gateway.impl.dataobject.AcceptPrizeDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【bld_accept_prize】的数据库操作Mapper
* @createDate 2022-11-26 23:02:26
* @Entity cn.j3code.lduser.po.AcceptPrize
*/
public interface AcceptPrizeMapper extends BaseMapper<AcceptPrizeDB> {

    AcceptPrizeDB getByRecordId(@Param("recordId") Long recordId);
}




