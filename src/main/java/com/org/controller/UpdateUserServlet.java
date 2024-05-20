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

@WebServlet("/update_user")
public class UpdateUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		long mobile =Long.parseLong(request.getParameter("mobile"));
		String email =request.getParameter("email");
		
		HttpSession session =request.getSession();
		User user=(User) session.getAttribute("userObj");
		
		Note note=new Note();
		User updatedUser=new User();
		updatedUser.setId(id);
		updatedUser.setName(name);
		updatedUser.setAge(age);
		updatedUser.setMobile(mobile);
		updatedUser.setEmail(email);
		updatedUser.setPassword(user.getPassword());
		
		List<Note>list=user.getNotesList();
		
		user.setNotesList(list);
		note.setUser(updatedUser);
		
		UserDao dao=new UserDao();
		dao.saveAndUpdateUser(updatedUser);
		
		session.setAttribute("success", "User Updated Successfully");
		response.sendRedirect("home.jsp");
	}
}
