package com.rab3.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rab3.entities.CategoryEntity;
import com.rab3.entities.CustomerEntity;

@Repository
public class CategoryRepository {

	private SessionFactory sessionFactory;
	
	public void save(CategoryEntity category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void update(CategoryEntity category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(category);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public CategoryEntity  getcategoryByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from CategoryEntity c where c.name =:name");
		query.setParameter("name", name);
		CategoryEntity category = (CategoryEntity) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return category;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
