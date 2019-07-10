package com.test.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.base.server.project.mapper.BaseMapper;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.base.server.comm.config.RootConfig.class })
public class selectTest {

	@Setter(onMethod_ = @Autowired)
	private BaseMapper mapper;
	
	@Test
	public void test() throws Exception {
		System.out.println(mapper.selectIndex());
	}

}