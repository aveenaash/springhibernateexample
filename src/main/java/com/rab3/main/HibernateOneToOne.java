package com.rab3.main;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.CustomerEntity;
import com.rab3.entities.CustomerLoginEntity;
import com.rab3.repositories.CustomerLoginRepository;

public class HibernateOneToOne {

	public static void main(String[] args) {
		
//		CustomerLoginEntity customerLogin = new CustomerLoginEntity();
//		customerLogin.setUsername("abcde");
//		String password = DigestUtils.sha256Hex("1234567");
//		customerLogin.setPassword(password);
//		customerLogin.setCreatedAt(new Date());
//		
//		CustomerEntity cust = new CustomerEntity();
//		cust.setName("222abinash");
//		cust.setEmail("abinash222@gmail.com");
//		cust.setPhone("22222222");
		
//		customerLogin.setCustomer(cust);
		ApplicationContext ctx = new 
				ClassPathXmlApplicationContext("application-context.xml");
		
		CustomerLoginRepository customerLoginRepository = (CustomerLoginRepository) ctx.getBean("customerLoginRepository");
//		customerLoginRepository.save(customerLogin);
		
		
		CustomerLoginEntity cl = customerLoginRepository.getByUsername("abcde");
		System.out.println("*************login get by username **********");
		System.out.println(cl.toString());
		
		String password = DigestUtils.sha256Hex("08234721");
		cl.setPassword(password);
		cl.setUpdatedAt(new Date());
		
		customerLoginRepository.update(cl);
		
		
		
		
	}

}
