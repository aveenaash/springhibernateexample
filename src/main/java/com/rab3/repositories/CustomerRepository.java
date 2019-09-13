package com.rab3.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rab3.entities.CustomerEntity;

@Repository
public class CustomerRepository {

	private SessionFactory sessionFactory;
	
	public void save(CustomerEntity customer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<CustomerEntity>  getCustomerByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from CustomerEntity c where c.name =:namePmr");
		query.setParameter("namePmr", name);
		List<CustomerEntity> custList = query.list();
		
		session.getTransaction().commit();
		session.close();
		return custList;
	}
	
	public CustomerEntity getCustomerById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CustomerEntity cust = (CustomerEntity) session.get(CustomerEntity.class, id);
		session.getTransaction().commit();
		session.close();
		
		return cust;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
