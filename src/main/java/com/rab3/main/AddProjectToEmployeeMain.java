package com.rab3.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.EmployeeEntity;
import com.rab3.entities.ProjectEntity;
import com.rab3.repositories.EmployeeRepository;
import com.rab3.repositories.ProjectRepository;


public class AddProjectToEmployeeMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeRepository employeeRepository = (EmployeeRepository) 
				ctx.getBean("employeeRepository");
		
		ProjectRepository projectRepository = (ProjectRepository) 
				ctx.getBean("projectRepository");
		
		EmployeeEntity e1 = employeeRepository.getEmployeeByEmail("employee2@projects.com");
		
		ProjectEntity p1 = projectRepository.getProjectByName("EMBO");
		
		e1.getProjects().add(p1);
		
		employeeRepository.update(e1);
		
	}

}
