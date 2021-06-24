package com.java.springbootapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.java.springbootapplication.security.ApplicationUserRole.ADMIN;
import static com.java.springbootapplication.security.ApplicationUserRole.USER;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("patryk")
                .password(passwordEncoder.encode("1234"))
                .roles(ADMIN.name());
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("user"))
                .roles(USER.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "css/*", "/js/*").permitAll()
                .antMatchers("/api/cars/**", "/h2-console/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
        http
                .headers().frameOptions().disable();
    }
}