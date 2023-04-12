<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<div class="card-header">
						<h2>Add Book</h2>
					</div>
					<div class="card-body">
						<form:form action="addbook" modelAttribute="book" method="POST">
							<div class="mb-3">
								<label class="from-label">Enter book name</label>
								<form:input path="bookName" class="form-control" />
							</div>
							<div class="mb-3">
								<label class="from-label">Enter Author Name</label>
								<form:input path="bookAuthor" class="form-control" />
							</div>

							<div class="mb-3">
								<label class="from-label">Enter book name</label>
								<form:input path="price" class="form-control" />
							</div>
							<div>
								<p class="form-text text-success">${msg}</p>
							</div>
							<div class="d-flex justify-content-start">
								<div class="me-2">
									<input type="submit" value="Add Book" class="btn btn-primary" />
								</div>
								<div>
									<button class="btn btn-warning">
										<a href="viewallbooks">View All Books</a>
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>

	</div>

</body>
</html>