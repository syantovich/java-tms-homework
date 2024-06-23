package org.example.configs;

import org.example.entities.PersonEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
        Properties prop = new Properties();
        prop.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/tms_db");
        prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.put("hibernate.connection.username", "postgres");
        prop.put("hibernate.connection.password", "root");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.hbm2ddl.auto", "create");

        config.addProperties(prop);
        config.addAnnotatedClass(PersonEntity.class);

        return config.buildSessionFactory();
    }
}
