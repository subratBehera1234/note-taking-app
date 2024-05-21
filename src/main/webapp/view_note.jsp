<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dao.NotesDao"%>
<%@page import="com.org.dto.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view notes</title>
<%@ include file="components/bootstrap-css.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<% int userId =(Integer) session.getAttribute("userId");
UserDao dao=new UserDao();
User sessionUser=dao.fetchUserById(userId);
	if(sessionUser==null){
		response.sendRedirect("login.jsp");
	}
	else{
		
%>
	<%int id=Integer.parseInt(request.getParameter("id"));
						NotesDao Notedao=new NotesDao();
						 Note n= Notedao.fetchNoteById(id);
						%>
<%@ include file="components/homeNavbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">View Note</p>
					
						<form action="update_notes" method="post">
					
							<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control"value="<%=n.getTitle()%> " >
							</div>
							<input type="hidden" name="id" value="<%=n.getNoteId()%>">
							<div class="mb-3">
								<label class="form-label">Description</label> 
								<textarea rows="10" cols="46" class="form-control" name="description"><%=n.getDescription() %></textarea>
							</div>
								<button type="submit" class="btn bg-primary text-white col-md-12">Update Notes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
</body>
</html>