package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.NotesDao;

@WebServlet("/delete_note")
public class DeleteNoteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		NotesDao dao=new NotesDao();
		dao.deleteNoteById(id);
		HttpSession session=request.getSession();
		session.setAttribute("success", "Note Deleted Successfully");
		response.sendRedirect("home.jsp");
	}
}
