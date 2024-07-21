package com.example.hometask45.config;

import com.example.hometask45.ERoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests(qw -> {
            qw
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/task").authenticated()
                    .requestMatchers("/order").hasRole(ERoles.SELLER.toString());
        }).httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();
        UserDetails seller = User.withUsername("seller").password(encoder.encode("qwerty")).roles(ERoles.SELLER.toString()).build();
        UserDetails user = User.withUsername("user").password(encoder.encode("qwerty")).build();

        return new InMemoryUserDetailsManager(seller,user);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
