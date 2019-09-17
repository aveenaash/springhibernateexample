package com.rab3.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.EmployeeEntity;
import com.rab3.entities.ProjectEntity;
import com.rab3.repositories.EmployeeRepository;
import com.rab3.repositories.ProductRepository;
import com.rab3.repositories.ProjectRepository;


public class SaveProjectMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("application-context.xml");
		ProjectEntity project1 = new ProjectEntity();
		project1.setName("EMBO");
		project1.setDescription("back office application");
		project1.setBudget(150000d);
		project1.setLocation("Vienna, VA");
		
		ProjectEntity project2 = new ProjectEntity();
		project2.setName("Athen");
		project2.setDescription("middle office application");
		project2.setBudget(190000d);
		project2.setLocation("Vienna, VA");
		
		ProjectRepository projectRepository = (ProjectRepository) 
				ctx.getBean("projectRepository");
		
		projectRepository.save(project1);
		projectRepository.save(project2);
		
	}

}
