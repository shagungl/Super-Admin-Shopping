package com.globallogic.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/getrequest")
	public ModelAndView getMessage(@RequestParam Map<String,String> map)
	{
		
		//connection 
		
		//connection
		
		
		
		map.forEach((k,v)->System.out.println("key "+k +" value "+v));
		System.out.println("hello Controller get");
		ModelAndView modelAndView=new ModelAndView("/home");
		String name="ravinder";
		modelAndView.addObject("name",name);
		modelAndView.addObject("age","35");
		modelAndView.addObject("salary",1000);
		System.out.println("?");
		return modelAndView;
	}
	/*
	 * @RequestMapping(method = RequestMethod.POST, path = "/") public void
	 * postMessagePost() { System.out.println("hello Controlle post");
	 * System.out.println("?"); }
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, path = "/") public void
	 * putMessage() { System.out.println("hello Controlle put");
	 * System.out.println("?"); }
	 * 
	 * @RequestMapping(method = RequestMethod.DELETE, path = "/") public void
	 * deleteMessage() { System.out.println("hello Controlle delete");
	 * System.out.println("?"); }
	 */
	
}
