package org.example;

import org.example.configs.App;
import org.example.services.BetInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        BetInfoService betInfoService = context.getBean(BetInfoService.class);
        betInfoService.startGame();
    }
}