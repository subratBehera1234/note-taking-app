package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;

import com.org.dto.Note;
import com.org.dto.User;

public class NotesDao{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public Note fetchNoteById(int id) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		
		return em.find(Note.class, id);
	}
	
	public List<Note> fetchAllNotes(){
		
		
		Query query=em.createQuery("select n from Note n");
		List<Note> list=query.getResultList();
		if(list !=null) {
			return list;
		}
		return null;
	}
	
	public void deleteNoteById(int id) {
		Note notes=em.find(Note.class, id);
		
		User user=notes.getUser();
		List<Note>list=user.getNotesList();
		
		for(Note n:list) {
			if(n.getNoteId()==id) {
				list.remove(n);
				break;
			}
		}
		et.begin();
		em.remove(notes);
		em.merge(user);
		et.commit();
		
	}
}
