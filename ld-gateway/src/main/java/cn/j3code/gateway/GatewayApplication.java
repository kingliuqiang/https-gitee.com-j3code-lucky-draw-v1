package cn.j3code.gateway;

import cn.j3code.gateway.resolver.IpKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean("ipKeyResolver")
    public IpKeyResolver ipKeyResolver(){
        return new IpKeyResolver();
    }

}
