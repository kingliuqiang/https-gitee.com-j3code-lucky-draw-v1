package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/12/2 - 23:52
 * @description
 */
@Data
public class ActivityListByParamQuery extends PageQuery {

    private Long id;

    private String activityName;

    /**
     * 开始时间
     */
    @NotNull(message = "开始时间不为空")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @NotNull(message = "结束时间不为空")
    private LocalDateTime endTime;

    /**
     * 活动状态（0、1、2）
     */
    private Integer status;

}
