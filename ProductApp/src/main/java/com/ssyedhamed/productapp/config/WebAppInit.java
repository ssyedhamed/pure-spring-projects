package com.ssyedhamed.productapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(WebMvcConfig.class,SpringHiberConfig.class);
		DispatcherServlet ds=new  DispatcherServlet(context);
		Dynamic dispatcherServlet = servletContext.addServlet("ds", ds);
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
		
	}

}
