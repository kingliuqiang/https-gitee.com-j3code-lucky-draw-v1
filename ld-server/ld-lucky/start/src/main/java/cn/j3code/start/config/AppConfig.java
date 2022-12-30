package cn.j3code.start.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author J3（about：https://j3code.cn）
 * @package cn.j3code.start.config
 * @createTime 2022/12/9 - 22:43
 * @description
 */
@EnableFeignClients(basePackages = "cn.j3code.luckyclient.feign")
@Configuration
@EnableScheduling
@EnableTransactionManagement
@ComponentScan("cn.j3code")
@MapperScan(basePackages = "cn.j3code.luckyinfrastructure.gateway.impl.mapper")
public class AppConfig {
}
