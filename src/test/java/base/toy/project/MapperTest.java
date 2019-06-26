package base.toy.project;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.base.config.RootConfig;
import com.base.controller.HomeController;
import com.base.mapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class MapperTest {

	@Setter(onMethod_ = { @Autowired })
	private TestMapper testMapper;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Test
	public void testMyBatis() {

		logger.info(testMapper.getClass().getName());
		logger.info(testMapper.select());
	}
}
