package com.base.server.project.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.base.server.project.service.BaseService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("BaseService")
	private BaseService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private SessionLocaleResolver sessionLocaleResolver;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {		
		
		logger.info("한글:" + messageSource.getMessage("title", null, "no surch", Locale.KOREA));
		
		locale = new Locale("ss");
		sessionLocaleResolver.setLocale(request, response, locale);
		
		model.addAttribute("sessionLocale", sessionLocaleResolver.resolveLocale(request));
		
		service.test();
		
		// throw를 발생시켜서 CommonExceptionAdvice class의 except함수 호출
		//throw new Exception("에러");
	    		
		return "home";
	}
	
}
