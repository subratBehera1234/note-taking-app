  <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrap-css.jsp" %>
</head>
<body>

<% User sessionUser =(User) session.getAttribute("userObj");
	if(sessionUser==null){
		response.sendRedirect("login.jsp");
	}
	else{
%>
<%@ include file="components/homeNavbar.jsp" %>
<h1 class=" text-center text-success">Welcome MoNotes</h1>

						

	
<% } %>


</body>
</html>