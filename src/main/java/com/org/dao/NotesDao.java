package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;

import com.org.dto.Note;

public class NotesDao{

	public Note fetchNoteById(int id) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		
		return em.find(Note.class, id);
	}
	
	public List<Note> fetchAllNotes(){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select n from Note n");
		List<Note> list=query.getResultList();
		if(list !=null) {
			return list;
		}
		return null;
	}
	
	public void deleteNoteById(int id) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Note n=em.find(Note.class, id);
		et.begin();
		em.remove(n);
		et.commit();
		
	}
}
