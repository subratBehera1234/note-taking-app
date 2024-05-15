package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;

import com.org.dto.Note;

public class NotesDao{

	public Note fetchNoteById(int id) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("subrat");
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select n from Note n where n.id=?1");
		List<Note>list=query.getResultList();
		if(list !=null) {
			for(Note n:list) {
				return n;
			}
		}
		return null;
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
}
