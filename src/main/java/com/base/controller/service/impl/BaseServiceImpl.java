package com.base.controller.service.impl;

import org.springframework.stereotype.Service;

import com.base.controller.service.BaseService;

@Service("BaseService")
public class BaseServiceImpl implements BaseService {

	public void test() throws Exception {
		System.out.println("test!");
	}	
}
