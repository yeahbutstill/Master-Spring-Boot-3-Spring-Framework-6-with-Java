package com.yeahbutstill.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class BasicAuthSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                auth -> {
                    auth
                            // Global Security
                            //.requestMatchers("/api/v1/users").hasRole("USER")
                            //.requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                            .anyRequest().authenticated();
                });
        httpSecurity.httpBasic();
        httpSecurity.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().sameOrigin();

        return httpSecurity.build();

    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        UserDetails userBu = User.withUsername("yeahbutstill")
                .password("sangatrahasia")
                .passwordEncoder(str -> bCryptPasswordEncoder().encode(str))
                .roles("USER_BU")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("sangatrahasia")
                .passwordEncoder(str -> bCryptPasswordEncoder().encode(str))
                .roles("ADMIN")
                .build();

        var userBPR = User.withUsername("ics.gssk05")
                .password("dummy")
                .passwordEncoder(str -> bCryptPasswordEncoder().encode(str))
                .roles("USER_BPR")
                .build();

        var adminIcs = User.withUsername("admin.ics")
                .password("dummy")
                .passwordEncoder(str -> bCryptPasswordEncoder().encode(str))
                .roles("ADMIN_ICS")
                .build();

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(userBu);
        jdbcUserDetailsManager.createUser(admin);
        jdbcUserDetailsManager.createUser(userBPR);
        jdbcUserDetailsManager.createUser(adminIcs);

        return jdbcUserDetailsManager;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}