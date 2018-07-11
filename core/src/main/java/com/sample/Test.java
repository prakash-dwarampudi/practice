package com.sample;

public class Test {
	
	public static void main(String[] s){
		EmployeeService_Service empServiceS = new EmployeeService_Service();
		EmployeeService empService= empServiceS.getEmployeeServiceImplPort();
		
		Employee emp = new Employee();
		emp.setName("Prakash");
		emp.setDept("DEV");
		emp.setAge(20);
		
		System.out.println(empService.createEmployee(emp));
		System.out.println(empService.getEmployee("Prakash").getAge());
	}

}
