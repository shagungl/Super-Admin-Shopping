package com.globallogic.day18;

class Employee {
	

	int id;
	String name;
	
	public Employee() {

	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}

public class MyEmployeeDI {

	public static void main(String[] args) {
		                              //Dependancy 
		Employee employee=new Employee();
		System.out.println(employee);
		
		//1001, "Ravinder"
		//keep the dependency in separate file and load the dependency when you want
		//Constructor 
		
	}
}
