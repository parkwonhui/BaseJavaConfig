package base.toy.project;

import javax.sql.DataSource;

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

		/*try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {
			logger.info(con+"");

		} catch (Exception e) {
			logger.info("실패" + e.getMessage());
			fail(e.getMessage());
		}*/
		logger.debug("logback으로 변경!!!");
		logger.info("logback으로 변경!!!");

	}
}
