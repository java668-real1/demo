package com.java668.oxadmin.config;

import com.java668.oxadmin.component.AuthorizationManager;
import com.java668.oxadmin.component.RestAuthenticationEntryPoint;
import com.java668.oxadmin.component.RestfulAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationEntryPointFailureHandler;

/**
 * 资源服务器配置
 *
 * @author zlt
 * @date 2019/10/5
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@RequiredArgsConstructor
@Configuration
public class ResourceServerConfiguration {

    private final TokenStore tokenStore;
    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final AuthorizationManager authorizationManager;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        JsonAuthenticationEntryPoint entryPoint = new JsonAuthenticationEntryPoint();
        //认证处理器
        ReactiveAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(tokenStore);
        //token转换器
        ServerBearerTokenAuthenticationConverter tokenAuthenticationConverter = new ServerBearerTokenAuthenticationConverter();
        tokenAuthenticationConverter.setAllowUriQueryParameter(true);
        //oauth2认证过滤器
        AuthenticationWebFilter oauth2Filter = new AuthenticationWebFilter(customAuthenticationManager);
        oauth2Filter.setServerAuthenticationConverter(tokenAuthenticationConverter);
        oauth2Filter.setAuthenticationFailureHandler(new ServerAuthenticationEntryPointFailureHandler(entryPoint));
        oauth2Filter.setAuthenticationSuccessHandler(new Oauth2AuthSuccessHandler());
        oauth2Filter.setRequiresAuthenticationMatcher(new CustomServerWebExchangeMatchers(ignoreUrlsConfig));
        http.addFilterAt(oauth2Filter, SecurityWebFiltersOrder.AUTHENTICATION);



        ServerHttpSecurity.AuthorizeExchangeSpec authorizeExchange = http.authorizeExchange();
        authorizeExchange
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .pathMatchers(ignoreUrlsConfig.getUrls()).permitAll()//白名单配置
                .anyExchange()

                    .access(authorizationManager)
                .and()
                    .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)//处理未授权
                .authenticationEntryPoint(restAuthenticationEntryPoint)//处理未认证
                .and()
                    .headers()
                        .frameOptions()
                        .disable()
                .and()
                    .httpBasic().disable()
                    .csrf().disable();
        return http.build();
    }
}
