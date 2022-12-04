package cn.j3code.lduser.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName ld_activity_rule
 */
@TableName(value ="ld_activity_rule")
@Data
public class ActivityRule implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 规则id
     */
    private Long ruleId;

    /**
     * 
     */
    private Date createTimie;

    /**
     * 
     */
    private String creator;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}