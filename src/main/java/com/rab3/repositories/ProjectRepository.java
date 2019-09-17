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
import com.rab3.entities.ProjectEntity;

@Repository
public class ProjectRepository {

	private SessionFactory sessionFactory;
	
	public void save(ProjectEntity project) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void update(ProjectEntity project) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(project);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public ProjectEntity  getProjectByName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from ProjectEntity p where p.name = :name");
		query.setParameter("name", name);
		ProjectEntity project = (ProjectEntity) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return project;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
