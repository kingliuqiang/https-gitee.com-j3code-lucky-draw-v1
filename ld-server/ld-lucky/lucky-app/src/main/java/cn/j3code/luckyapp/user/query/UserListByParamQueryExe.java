package cn.j3code.luckyapp.user.query;

import cn.j3code.luckyapp.assembler.UserAssembler;
import cn.j3code.luckyclient.dto.data.UserVO;
import cn.j3code.luckyclient.dto.query.UserListByParamQuery;
import cn.j3code.luckydomain.gateway.UserGateway;
import cn.j3code.luckydomain.user.UserEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.luckyapp.user.query
 * @createTime 2022/11/29 - 23:31
 * @description
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserListByParamQueryExe {

    private final UserGateway userGateway;

    public IPage<UserVO> execute(UserListByParamQuery query) {
        IPage<UserEntity> entityIPage = userGateway.listByParamQuery(query);
        return entityIPage.convert(UserAssembler::toUserVO);
    }
}
