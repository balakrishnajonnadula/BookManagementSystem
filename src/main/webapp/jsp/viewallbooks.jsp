<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
	
<!-- Datatable plugin CSS file -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />

<!-- jQuery library file -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js">
	
</script>

<!-- Datatable plugin JS library file -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
	
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="card">
					<div class="card-header">
						<h2>Books List</h2>
					</div>
					<div class="card-body">
						<table class="display" id="tableID">

							<thead>
								<tr>
									<th>Book Id</th>
									<th>Name</th>
									<th>Author</th>
									<th>Price</th>
									<th>Edit</th>
									<th>View</th>
									<th>Delete</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="b" items="${books}">
									<tr>
										<td>${b.bookId}</td>
										<td>${b.bookName}</td>
										<td>${b.bookAuthor}</td>
										<td>${b.price}</td>
										<td><a href="edit?id=${b.bookId}">Edit</a></td>
										<td><a href="view?id=${b.bookId}">View</a></td>
										<td><a href="delete?id=${b.bookId}">Delete</a></td>
									</tr>
								</c:forEach>

							</tbody>
							<tfoot>
								<div class="my-3">
									<button class="btn btn-warning"><a href="pdf">PDF</a></button>
									<button class="btn btn-warning"><a href="excel">XLS</a></button>
									<button class="btn btn-warning"><a href="email">EMail</a></button>
								</div>
								<div>
									<h4>${msg} ${path}</h4>
								</div>
							</tfoot>
						</table>
					</div>
					<div class="card-footer">
						<a href="/">Back</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		/* Initialization of datatable */
		$(document).ready(function() {
			$('#tableID').DataTable({
				pageLength:5
			});
		});
	</script>
</body>
</html>