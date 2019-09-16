package com.rab3.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.CustomerEntity;
import com.rab3.repositories.CustomerRepository;

public class HibernateMain {

	public static void main(String[] args) {
//		CustomerEntity cust = new CustomerEntity();
//		cust.setName("abinash");
//		cust.setEmail("abinash@gmail.com");
//		cust.setPhone("1342412341");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository customerRepository = (CustomerRepository) ctx.getBean("customerRepository");
//		customerRepository.save(cust);
		
		System.out.println("**************************");
		List<CustomerEntity> customers = customerRepository.getCustomerByName("abinash");
		for(CustomerEntity c : customers) {
			System.out.println(c.toString());
		}
		
		System.out.println();
		System.out.println("**************************");
		
		
		CustomerEntity customer1 = customerRepository.getCustomerById(4l);
		System.out.println(customer1.toString());
		
		System.out.println("******* update example*********");
		CustomerEntity custUpdate = customerRepository.getCustomerById(5l);
		custUpdate.setEmail("updatedneweamil@gmail.com");
		custUpdate.setPhone("10000000000");
		customerRepository.update(custUpdate);
		
		
		
		
	}

}
