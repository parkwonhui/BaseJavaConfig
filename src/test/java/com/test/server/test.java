package com.test.server;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.base.server.comm.config.RootConfig;
import com.base.server.comm.util.PropertiesSearch;
import com.base.server.project.controller.HomeController;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class test {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;

	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testMyBatis() {

		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {
			logger.info(con+"");

		} catch (Exception e) {
			logger.info("실패" + e.getMessage());
			logger.error(e.getMessage());
		}
		
		PropertiesSearch prop = new PropertiesSearch("properties/mariadb/mariadb", "local");
		logger.info(prop.getProperties("mariadb.driver"));
		logger.info(prop.getProperties("mariadb.url"));
		logger.info(prop.getProperties("mariadb.username"));
		logger.info(prop.getProperties("mariadb.password"));	
	}
}
