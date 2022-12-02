package cn.j3code.luckyclient.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto.query
 * @createTime 2022/12/2 - 22:38
 * @description
 */
@Data
public class AwardListByParamQuery extends PageQuery {

    private Long id;

    private Long activityId;

    private String activityName;

    private String awardName;
}
