package com.base.server.comm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	// exception 이 발생하고 try~catch 문이 아닌 호출된 곳에서 처리하도록 하면 여기에 들어온다
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		logger.info("Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		logger.error(model.toString());
		return "error/error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		
		return "error/error_404";
	}
}
