package com.java668.oxadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;


/**
 * @author Jerry
 */
@Configuration
public class SpringSecurityBean {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 授权码管理策略
    @Bean
    public AuthorizationCodeServices jdbcAuthorizationCodeServices() {
//        return new JdbcAuthorizationCodeServices(dataSource);
        return new InMemoryAuthorizationCodeServices();
    }
}
