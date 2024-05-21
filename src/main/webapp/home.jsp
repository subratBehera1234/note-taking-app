  <%@page import="com.org.dto.Note"%>
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

<% int userId =(Integer)session.getAttribute("userId");
	if(userId==0){
		response.sendRedirect("login.jsp");
	}
	else{
%>
<%@ include file="components/homeNavbar.jsp" %>
<h1 class=" text-center text-success">Welcome To My Notes</h1>

<% String msg=(String) session.getAttribute("success"); 
						if(msg !=null){
							%>
							<p class="text-center text-success fs-4"><%= msg %></p>
							<% session.removeAttribute("success"); } %>
						
						<%
						UserDao dao=new UserDao();
						User user=dao.fetchUserById(userId);
						List<Note>list=user.getNotesList();
						%>
		

	<div class="container" border>
<div>
<a href="add_notes.jsp" class="btn bg-primary text-white ">Add Notes</a>
</div>
<div class="row">
<% 
for(Note n:list){
	%>
<div class="col-md-4 card border border-primary m-4" style="width: 15rem">
	<div class="card-body">
	<div class="d-flex flex-wrap justify-content-evenly">
	<div>
	<h2 class="text-success card-title"><%=n.getTitle() %></h2>
	<a href="view_note.jsp?id=<%=n.getNoteId()%>" class="btn btn-sm btn-info">view</a>
		<a href="view_note.jsp?id=<%=n.getNoteId()%>" class="btn btn-sm btn-info">update</a>
			<a href="delete_note?id=<%=n.getNoteId()%>" class="btn btn-sm btn-danger">delete</a>
		
	
	</div>
	</div>
	</div>
	</div>
<% } %>

<% } %>
</body>
</html>