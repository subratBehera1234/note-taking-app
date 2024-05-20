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
@WebServlet("/add_notes")
public class AddNotesServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title=request.getParameter("title");
		String description =request.getParameter("description");
		
		Note note=new Note();
		note.setTitle(title);
		note.setDescription(description);
		
		HttpSession session =request.getSession();
		User user=(User) session.getAttribute("userObj");
		
		List<Note>list=new ArrayList<>();
		list.add(note);
		
		user.setNotesList(list);
		note.setUser(user);
		
		UserDao dao=new UserDao();
		dao.saveAndUpdateUser(user);
		
		session.setAttribute("success", "Notes Added Successfully");
		response.sendRedirect("home.jsp");
	}
}
