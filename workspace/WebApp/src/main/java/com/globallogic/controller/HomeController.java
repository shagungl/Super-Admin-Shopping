package com.globallogic.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.globallogic.dao.MyConnection;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/getrequest")
	public ModelAndView getMessage(@RequestParam Map<String,String> map) throws Exception
	{
		Connection conn=null;
		//connection 
		 MyConnection connection=new MyConnection();
		 conn= connection.getConnection();
		//connection
		 Statement st=conn.createStatement();
		 
		
		
		//map.forEach((k,v)->System.out.println("key "+k +" value "+v));
		System.out.println("hello Controller get");
		ModelAndView modelAndView=new ModelAndView("/home");
		//String name="ravinder";
		modelAndView.addObject("name",map.get("name"));
	
		return modelAndView;
	}

}
