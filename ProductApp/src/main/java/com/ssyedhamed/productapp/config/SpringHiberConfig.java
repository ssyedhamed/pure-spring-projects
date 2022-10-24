package com.ssyedhamed.productapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@Configuration
@ComponentScan(basePackages = "com.ssyedhamed")
public class SpringHiberConfig {
	@Autowired
	private Environment en;

	@Bean
	public HibernateTemplate template() {
		HibernateTemplate template = new HibernateTemplate(getSessionFactory().getObject());
		return template;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setAnnotatedClasses(com.ssyedhamed.productapp.entity.Product.class);
		factory.setHibernateProperties(hibernateProps());

		return factory;
	}

	@Bean
	public Properties hibernateProps() {
		Properties p = new Properties();
		p.put("hibernate.dialect", en.getRequiredProperty("dialect"));
		p.put("hibernate.hbm2ddl.auto", en.getRequiredProperty("table"));
		p.put("hibernate.show_sql", en.getRequiredProperty("show_sql"));
		p.put("hibernate.format_sql", en.getRequiredProperty("format_sql"));
		return p;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(en.getRequiredProperty("driverName"));
		source.setUrl(en.getRequiredProperty("url"));
		source.setUsername("root");
		source.setPassword("root");
		return source;
	}

	@Bean
	public TransactionManager tx() {
		HibernateTransactionManager tx = new HibernateTransactionManager(getSessionFactory().getObject());
		return tx;
	}
}
