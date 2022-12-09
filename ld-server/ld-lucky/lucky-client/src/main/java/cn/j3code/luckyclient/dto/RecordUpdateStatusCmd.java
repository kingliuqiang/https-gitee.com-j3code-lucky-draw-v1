package cn.j3code.luckyclient.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyclient.dto
 * @createTime 2022/12/9 - 23:19
 * @description
 */
@Data
public class RecordUpdateStatusCmd extends Command {

    /**
     *
     */
    private Long id;

    /**
     * 状态（0，1，2，3）
     */
    private Integer state;
}
