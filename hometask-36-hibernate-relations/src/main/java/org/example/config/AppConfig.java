package org.example.config;

import org.example.entities.OrderEntity;
import org.example.entities.PersonEntity;
import org.example.entities.ProductEntity;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.mutation.OperationResultChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/tms_db");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.hbm2ddl.auto", "create");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(ProductEntity.class);
        configuration.addAnnotatedClass(PersonEntity.class);
        configuration.addAnnotatedClass(OrderEntity.class);
        return configuration.buildSessionFactory();
    }
}
