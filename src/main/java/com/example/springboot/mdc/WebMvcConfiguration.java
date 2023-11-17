package com.example.springboot.mdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName WebMvcConfiguration.java
 * @Description 使用日志标识生成拦截器,配置拦截器
 * @createTime 2021年12月28日 10:24:00
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

 /**
  * 在WebMvc配置加上LogInterceptor
  */
 @Autowired
 private LogInterceptor logInterceptor;
 @Override
 public void addInterceptors(InterceptorRegistry registry) {
  registry.addInterceptor(logInterceptor);
 }
}
