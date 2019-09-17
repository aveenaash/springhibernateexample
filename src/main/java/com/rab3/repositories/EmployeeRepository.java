package com.rab3.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rab3.entities.CategoryEntity;
import com.rab3.entities.CustomerEntity;
import com.rab3.entities.EmployeeEntity;
import com.rab3.entities.ProductEntity;

@Repository
public class EmployeeRepository {

	private SessionFactory sessionFactory;
	
	public void save(EmployeeEntity employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void update(EmployeeEntity employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(employee);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public EmployeeEntity  getEmployeeByEmail(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from EmployeeEntity e where e.email = :emailParam");
		query.setParameter("emailParam", email);
		EmployeeEntity employee = (EmployeeEntity) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
