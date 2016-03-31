package com.exceltospira.port;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.exceltospira.port.adminService.adminstrativeService;

@EnableTransactionManagement
@Configuration
public class AppConfig
{
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/library";
	private static String username = "root";
	private static String password = "";

	@Bean
	public BasicDataSource dataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public PlatformTransactionManager txManager()
	{
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}

	@Bean
	public JdbcTemplate template()
	{
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		return template;
	}

	@Bean
	public adminstrativeService adminService()
	{
		return new adminstrativeService();
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	


	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver commonsMultipartResolver()
	{

		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();

		commonsMultipartResolver.setDefaultEncoding("utf-8");

		commonsMultipartResolver.setMaxUploadSize(50000000);

		return commonsMultipartResolver;

	}
}
