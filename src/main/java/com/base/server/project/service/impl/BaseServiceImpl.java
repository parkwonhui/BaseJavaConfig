package com.base.server.project.service.impl;

import org.springframework.stereotype.Service;

import com.base.server.project.service.BaseService;

@Service("BaseService")
public class BaseServiceImpl implements BaseService {

	public void test() throws Exception {
		System.out.println("test!");
	}	
}
