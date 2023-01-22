package com.yeahbutstill.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // all request should be authenticated
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // if a request is not authenticated, a web page is shown
        httpSecurity.httpBasic(Customizer.withDefaults());
        // CSRF -> POST, PUT
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
