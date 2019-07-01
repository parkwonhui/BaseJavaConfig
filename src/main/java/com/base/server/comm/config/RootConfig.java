package com.base.server.comm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.base.server.comm.util.PropertiesSearch;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.base.server")
public class RootConfig {

	@Value("${mariadb.username}")
	private String username;

	@Bean
	public DataSource dataSource() {
		System.out.println("****************************");
		System.out.println(username);
		PropertiesSearch prop = new PropertiesSearch("properties/mariadb/mariadb", "local");
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(prop.getProperties("mariadb.driver"));
		hikariConfig.setJdbcUrl(prop.getProperties("mariadb.url"));
		hikariConfig.setUsername(prop.getProperties("mariadb.username"));
		hikariConfig.setPassword(prop.getProperties("mariadb.password"));

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);

		return dataSource;
	}

//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//		sqlSessionFactory.setDataSource(dataSource());
//
//		return (SqlSessionFactory) sqlSessionFactory.getObject();
//
//	}

}
