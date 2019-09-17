package com.rab3.main;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.CategoryEntity;
import com.rab3.entities.ProductEntity;
import com.rab3.repositories.CategoryRepository;
import com.rab3.repositories.ProductRepository;


public class HibernateManyToOne {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		CategoryRepository categoryRepository = (CategoryRepository) ctx.getBean("categoryRepository");
		
		System.out.println("***** creating product*****");
		ProductEntity product1 = new ProductEntity();
		product1.setName("Mac book");
		product1.setBrand("Apple");
		product1.setDescription("thi is a macbook");
		product1.setPrice(1500d);
		product1.setCreatedAt(new Date());
		
		CategoryEntity categoryElctronics = categoryRepository.getcategoryByName("Electronics");
		
		product1.setCategory(categoryElctronics);
		
		
		ProductRepository productRepository = (ProductRepository) ctx.getBean("productRepository");
		productRepository.save(product1);
		
	}

}
