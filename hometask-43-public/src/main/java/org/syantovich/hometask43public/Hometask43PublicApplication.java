package org.syantovich.hometask43public;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Hometask43PublicApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hometask43PublicApplication.class, args);
    }

}
