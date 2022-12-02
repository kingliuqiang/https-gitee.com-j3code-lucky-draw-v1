package cn.j3code.luckydomain.activity;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckydomain.activity
 * @createTime 2022/12/2 - 23:37
 * @description
 */
@Entity
@Data
public class ActivityEntity {

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 活动名称
     */
    private String activityName;


    /**
     * 活动时间
     */
    private ActivityTime activityTime;


    /**
     * 描述
     */
    private String describe;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private String creator;

    /**
     *
     */
    private LocalDateTime updateTime;

    /**
     *
     */
    private String updater;


}
