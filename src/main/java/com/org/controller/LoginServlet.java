package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password"); 
		
		UserDao dao=new UserDao();
		User user=dao.fetchUserByEmailAndPassword(email,password);
		HttpSession session=request.getSession();
		if(user!=null) {
			session .setAttribute("userObj", user);
			response.sendRedirect("home.jsp");
			
		}
		else {
			
			session.setAttribute("fail","Invalid Credential");
			response.sendRedirect("login.jsp");
		}

	}
}
