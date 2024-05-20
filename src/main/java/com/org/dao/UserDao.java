package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {

	
	public void saveAndUpdateUser(User user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.merge(user);
		et.commit();
		
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		
		Query query=em.createQuery("select u from User u where u.email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List <User>list=query.getResultList();
		
		if(list !=null) {
			for(User u :list) {
				return u;
			}
		}
	return null;
//		if(list !=null) {
//			
//				return list.get(0);
//		}
//		return null;
	}
	public List<User> fetchAllUser(){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select u from User u");
		List<User> list=query.getResultList();
		return list;
	}


}
