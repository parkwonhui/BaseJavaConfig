package com.test.server;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.server.project.controller.HomeController;

import lombok.extern.log4j.Log4j;

public class mysqlDBTest {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Test
	public void testConnection() throws ClassNotFoundException {	
		 Class.forName("org.mariadb.jdbc.Driver");
	    try (Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3310/test", "test", "1234"))
		{
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
