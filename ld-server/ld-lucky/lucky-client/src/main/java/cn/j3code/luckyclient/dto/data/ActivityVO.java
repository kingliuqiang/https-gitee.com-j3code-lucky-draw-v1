package cn.j3code.luckyclient.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.data
 * @createTime 2022/12/2 - 23:50
 * @description
 */
@Data
public class ActivityVO {
    /**
     *
     */
    private Long id;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

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
