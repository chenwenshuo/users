package com.cws.users.spring;

import com.fasterxml.jackson.databind.util.ClassUtil;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wenshuo.chen@hand-china.com 2019/12/25 19:56
 * Springboot启动原理
 * @SpringBootApplication注解  和 SpringApplication.run
 * @Target({ElementType.TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Inherited
 * @SpringBootConfiguration   :继承了Configuration表示当前是注解类
 * @EnableAutoConfiguration   :开启springboot的注解功能，springboot的四大神器之一，其借助@import的帮助
 * @ComponentScan(
 *     excludeFilters = {@Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {TypeExcludeFilter.class}
 * ), @Filter(
 *     type = FilterType.CUSTOM,
 *     classes = {AutoConfigurationExcludeFilter.class}
 * )}
 * )
 *
 * 主要用到 @SpringbootConfiguration @EnableautoConfiguration
 * @SpringbootConfiguration
 *
 * 实际启动使用@Configuration
 * @EnableAutoConfiguration
 * @ComponentScan这三个注解就能启动springboot项目
 *
 * public @interface SpringBootApplication {
 *
 */
public class test {

    @Test
    public void  test(){
        //获取class的路径
        System.out.println(ClassUtil.getPackageName(test.class));
    }
    @Test
    public void  configurationTest(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ConfigurationTest.class);
        //获取bean
        TestBean tb = (TestBean) context.getBean("testBean");
     //   TestBean tb1 = (TestBean) context.getBean("testBean");
        System.out.println(tb);
       // System.out.println(tb1);
        tb.say();
    }
}
