package com.xxy.rpc.rpc_middleware_config_center_plat.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: XXY
 * @Date: 2020/5/28 23:05
 */
@Configuration
@MapperScan("com.xxy.rpc.rpc_middleware_config_center_plat.mapper*")
public class MybatisPlusConfiguration {
    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    @Bean
    public SqlInterceptor sqlInterceptor() {
        return new SqlInterceptor();
    }
}
