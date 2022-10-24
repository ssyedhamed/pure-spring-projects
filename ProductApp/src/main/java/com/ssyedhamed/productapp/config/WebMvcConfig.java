package com.ssyedhamed.productapp.config;

import javax.annotation.Resource;
import javax.servlet.FilterRegistration;

import org.apache.catalina.core.ApplicationFilterRegistration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ssyedhamed.productapp.controller")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver view() {
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		return view;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/WEB-INF/resources/");
    }
	
//	@Bean
//	public FilterRegistration cakesFilter()
//	{
//	   FilterRegistration registrationBean = new ApplicationFilterRegistration(null, null);
//	   registrationBean.;
//	   registrationBean.addUrlPatterns("/cakes/*");
//	   return registrationBean;
//	}
	
	
}
