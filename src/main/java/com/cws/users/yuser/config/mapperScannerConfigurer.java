package com.cws.users.yuser.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/10/21 10:13
 */
@Configuration
public class mapperScannerConfigurer {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //可以通过环境变量获取你的mapper路径,这样mapper扫描可以通过配置文件配置了
        scannerConfigurer.setBasePackage("com.cws.users.*.mapper");
        return scannerConfigurer;
    }
}
