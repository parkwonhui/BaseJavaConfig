package com.base.server.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.server.project.mapper.BaseMapper;
import com.base.server.project.service.BaseService;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service("BaseService")
@AllArgsConstructor
public class BaseServiceImpl implements BaseService {

	@Setter(onMethod_ = @Autowired)
	BaseMapper mapper;
	
	public void test() throws Exception {
		System.out.println("test!");
		mapper.selectIndex();
		
	}	
}
