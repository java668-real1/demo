package com.java668.oxadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Auther: 梦学谷 www.mengxuegu.com
 */
@Configuration
public class TokenConfig {

    //采用redis管理token
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    // jdbc管理token
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }


    @Bean
    public TokenStore tokenStore() {
        // redis 管理令牌
        return new RedisTokenStore(redisConnectionFactory);
//        return new JdbcTokenStore(dataSource());
    }

}
