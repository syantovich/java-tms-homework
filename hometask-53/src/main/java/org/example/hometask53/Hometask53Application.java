package org.example.hometask53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Hometask53Application {

    public static void main(String[] args) {
        SpringApplication.run(Hometask53Application.class, args);
    }

}
