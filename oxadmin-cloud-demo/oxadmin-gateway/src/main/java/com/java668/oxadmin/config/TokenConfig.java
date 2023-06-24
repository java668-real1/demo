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
//    public static final String SIGNING_KEY = "mengxeugu-key";

//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        // 对称加密进行签名令牌，资源服务器也要采用此密钥来进行解密,来校验令牌合法性
////        converter.setSigningKey(SIGNING_KEY);
//        // 非对称加密，资源服务器使用公钥解密 public.txt
//        ClassPathResource resource = new ClassPathResource("public.txt");
//        String publicKey = null;
//        try {
//            publicKey = IOUtils.toString(resource.getInputStream(), "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        converter.setVerifierKey(publicKey);
//        return converter;
//    }

//    @Bean
//    public TokenStore tokenStore() {
//        // Jwt管理令牌
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }

    @Bean
    public TokenStore tokenStore() {
        // redis 管理令牌
        return new RedisTokenStore(redisConnectionFactory);
//        return new JdbcTokenStore(dataSource());
    }
}
