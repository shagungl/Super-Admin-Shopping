package com.globallogic.demojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.globallogic.demojpa.entity.EmployeeEntity;
import com.globallogic.demojpa.repo.EmployeeRepo;

@RestController
@RequestMapping("/home")
public class HomeContoller {

	@Autowired
	EmployeeRepo repo;
	
	
	@GetMapping("/")
	public List<EmployeeEntity> showEmpoyee()
	{
		//return all the value from the tables
		return repo.findAll();
		
	}
	
}
