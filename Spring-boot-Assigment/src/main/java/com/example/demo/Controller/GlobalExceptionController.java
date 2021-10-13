package com.example.demo.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Exception.ItemException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ItemException.class)
	public ModelAndView handleItemException(ItemException exp) {
		exp.printStackTrace();
		return new ModelAndView("error-page","errMsg",exp.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleItemsException(Exception exp) {
		exp.printStackTrace();
		return new ModelAndView("error-page","errMsg","Some Internal Server Failure!");
	}
}
