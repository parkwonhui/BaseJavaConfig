package com.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {
	//@Select("SELECT id FROM test")
	@Select("SELECT * FROM dual")
	public String select();
}
