package com.globallogic.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MyEmployeeDI {

	public static void main(String[] args) {
		                              //dependency 
		//it will load the spring dependency 
		ApplicationContext context=new ClassPathXmlApplicationContext("data.xml");
		
		//Employee employee=new Employee();
		//System.out.println(employee);
		Employee emp=(Employee)context.getBean("employeeDataSetter");
		System.out.println(emp);
		
		//1001, "Ravinder"
		//keep the dependency in separate file and load the dependency when you want
		//Constructor
		//setter
		
	}
}
