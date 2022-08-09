package com.globallogic.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeConroller {
	
	@GetMapping("/")
	public String showMSG() {
		return "spring boot GET";
	}
	
	@PostMapping("/")
	public String showPostMSG() {
		return "spring boot Post";
	}
	
	@PutMapping("/")
	public String showPutMSG() {
		return "spring boot Put";
	}
	
	@DeleteMapping("/")
	public String showDeleteMSG() {
		return "spring boot Delete";
	}

}
