package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Note;
import com.org.dto.User;

@WebServlet("/update_notes")
public class UpdateNoteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title");
		String description =request.getParameter("description");
		int id=Integer.parseInt(request.getParameter("id"));
		
		Note note=new Note();
		note.setTitle(title);
		note.setDescription(description);
		note.setNoteId(id);
		
		HttpSession session =request.getSession();
		UserDao dao=new UserDao();
		
		int userId=(Integer) session.getAttribute("userId");
		User user=dao.fetchUserById(userId);
		
		List<Note>list=new ArrayList<>();
		list.add(note);
		
		user.setNotesList(list);
		note.setUser(user);
		
	
		dao.saveAndUpdateUser(user);
		
		session.setAttribute("success", "Notes Updaed Successfully");
		response.sendRedirect("home.jsp");
	}
}
