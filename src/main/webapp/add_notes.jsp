<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@ include file="components/bootstrap-css.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="components/homeNavbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Notes Here</p>
					
						<form action="add_notes" method="post">
						
							<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label> 
								<textarea rows="10" cols="46" class="form-control" name="description"></textarea>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Add notes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>