package com.java668.springboot.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jerry.chen
 * @desc
 * @date 2022/09/07 18:35
 **/
@Configuration
@MapperScan(basePackages = {"com.java668.springboot.mapper"})
public class MybatisPlusConfig {

    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 分页插件。如果你不配置，分页插件将不生效
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 指定数据库方言为 MYSQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 批量插入
     * @return
     */
    @Bean
    public EasySqlInjector easySqlInjector() {
        return new EasySqlInjector();
    }

}