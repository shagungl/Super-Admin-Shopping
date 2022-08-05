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
	
	@RequestMapping(value = "/gethome", method = RequestMethod.GET)
	public ModelAndView getHome(@RequestParam Map<String,String> map)
	{	
		//
		map.forEach((K,V) -> System.out.println(K + ", Stock : " + V));
		ModelAndView model=new ModelAndView("home");  //view name
		model.addObject("msg","hello world 111111111111111111111111");  //key and value
		model.addObject("msg2","hello world2222222222222222222"); //key and value
        return model;
	}

}
