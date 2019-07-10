package com.base.server.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseMapper {
	public List<Integer> selectIndex();
}