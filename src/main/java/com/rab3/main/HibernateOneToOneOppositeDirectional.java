package com.rab3.main;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.CustomerEntity;
import com.rab3.entities.CustomerLoginEntity;
import com.rab3.repositories.CustomerLoginRepository;
import com.rab3.repositories.CustomerRepository;

public class HibernateOneToOneOppositeDirectional {

	public static void main(String[] args) {
			
		CustomerEntity cust = new CustomerEntity();
		cust.setName("hahahaha");
		cust.setEmail("hahahaha@gmail.com");
		cust.setPhone("235353535");
		
		CustomerLoginEntity customerLogin = new CustomerLoginEntity();
		customerLogin.setUsername("hexaaa");
		String password = DigestUtils.sha256Hex("1234567");
		customerLogin.setPassword(password);
		customerLogin.setCreatedAt(new Date());
		customerLogin.setCustomer(cust);
		
		cust.setCustomerLoginEntity(customerLogin);
		
		
		ApplicationContext ctx = new 
				ClassPathXmlApplicationContext("application-context.xml");
		
		CustomerRepository customerRepository = (CustomerRepository) ctx.getBean("customerRepository");
		customerRepository.save(cust);	
		
	}

}
