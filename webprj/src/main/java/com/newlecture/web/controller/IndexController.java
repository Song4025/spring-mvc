package com.newlecture.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("이게 안찍혀요 controller");
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("data", "spring MVC");
		/* mv.setViewName("/WEB-INF/view/index.jsp"); */
		
		return mv;
	}
	
}