package cn.j3code.lduser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.j3code.lduser.po.Activity;
import cn.j3code.lduser.service.ActivityService;
import cn.j3code.lduser.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【bld_activity】的数据库操作Service实现
* @createDate 2022-11-26 23:02:19
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




