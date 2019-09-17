package com.rab3.main;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.CategoryEntity;
import com.rab3.entities.ProductEntity;
import com.rab3.repositories.CategoryRepository;


public class HibernateOneToMany {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		System.out.println("***** creating category*****");
//		CategoryEntity category = new CategoryEntity();
//		category.setName("Books");
//		category.setDescription("this is books");
//		category.setCreatedAt(new Date());
		
		CategoryRepository categoryRepository = (CategoryRepository) ctx.getBean("categoryRepository");
//		categoryRepository.save(category);
		
		CategoryEntity electonics = categoryRepository.getcategoryByName("Electronics");
		System.out.println("******category by name********");
		System.out.println(electonics.toString());
		
//		ProductEntity productiphone = new ProductEntity();
//		productiphone.setName("I phone X");
//		productiphone.setDescription("this is iphone x unlocked");
//		productiphone.setBrand("Apple");
//		productiphone.setPrice(1119d);
//		productiphone.setCreatedAt(new Date());
//		productiphone.setIsAvailable(true);
//		productiphone.setCategory(electonics);
//		
//		electonics.getProducts().add(productiphone);
//		categoryRepository.update(electonics);
		
		
		
		
		
	}

}
