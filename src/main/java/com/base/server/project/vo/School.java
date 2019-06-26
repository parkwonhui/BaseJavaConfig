package com.base.server.project.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class School {
	@Autowired
	private Student student;
}
