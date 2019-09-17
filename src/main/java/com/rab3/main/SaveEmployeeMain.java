package com.rab3.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.EmployeeEntity;
import com.rab3.repositories.EmployeeRepository;


public class SaveEmployeeMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeEntity employee = new EmployeeEntity();
		employee.setName("break2 Break");
		employee.setEmail("employee2@projects.com");
		employee.setPhone("2341241");
		employee.setPosition("QA");
		
		EmployeeRepository employeeRepository = (EmployeeRepository) 
				ctx.getBean("employeeRepository");
		
		employeeRepository.save(employee);
		
	}

}
