package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/12/9 - 23:19
 * @description
 */
@Data
public class RecordListByParamQuery extends PageQuery {

    private Long recordId;

    private Long userId;

    private Long activityId;

    /**
     * true：中奖，false：未中奖
     */
    private Boolean winTheLottery;


    private Integer status;
}
