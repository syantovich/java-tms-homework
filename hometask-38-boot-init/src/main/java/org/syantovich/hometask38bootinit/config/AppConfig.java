package org.syantovich.hometask38bootinit.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Autowired
    private AppProperties appProperties;

    @PostConstruct
    public void init() {
        System.out.println("App key is " + appProperties.getKey());
        System.out.println("ProfileName is " + appProperties.getProfileName());
        System.out.println("Version is " + appProperties.getVersion());

    }
}
