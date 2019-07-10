package com.test.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.base.server.comm.config.RootConfig;
import com.base.server.project.controller.HomeController;
import com.base.server.project.mapper.BaseMapper;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class MapperTest {

	@Setter(onMethod_ = { @Autowired })
	private BaseMapper testMapper;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Test
	public void testMyBatis() {

		logger.info(testMapper.getClass().getName());
		//logger.info(testMapper.select());
	}
}
