package com.newlecture.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/")
public class HomeController {

	//	annotation-drive을 반드시 해야함. 사용자요청을 수반할수있게하는 역활을 함.
	@RequestMapping("index")
	@ResponseBody
	public String index() {
		
		return "그냥 글씨일뿐이야";
		
		// return "root.index";
	}
	
	@RequestMapping("help")
	public void help() {
	}
	
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * System.out.println("이게 안찍혀요 controller");
	 * 
	 * ModelAndView mv = new ModelAndView("root.index"); mv.addObject("data",
	 * "spring MVC"); mv.setViewName("/WEB-INF/view/index.jsp");
	 * 
	 * return mv; }
	 */

}