package cn.j3code.ldwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LdWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdWalletApplication.class, args);
    }

}
