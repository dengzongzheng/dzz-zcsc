package com.dzz.zcsc.config.filter;


import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web 相关配置
 * @author dzz
 * @since  2016年09月21 上午11:26
 * @version 1.0.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 解决中文内容编码问题，统一用UTF-8编码
     * @return 统一编码
     */
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }


    /**
     * xss过滤,遇见特征属性字将会转义不中断请求
     * @param filterService 过滤器
     * @return 过滤器实体
     */
    @Bean
    public FilterRegistrationBean simpleFilterRegistration(SimpleFilterService filterService) {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("simpleFilter");
        registration.setFilter(new XssFilter(filterService));
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

}
