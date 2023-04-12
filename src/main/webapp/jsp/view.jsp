<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Book</title>
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
						<h4>Book Details</h4>
					</div>
					<div class="card-body">
						<h5 class="">
							Book Id : <span>${book.bookId}</span>
						</h5>
						<h5 class="">
							Name : <span>${book.bookName}</span>
						</h5>
						<h5 class="">
							Author : <span>${book.bookAuthor}</span>
						</h5>
						<h5 class="">
							Price : <span>${book.price}</span>
						</h5>

					</div>
					<div class="card-footer">
						<a href="viewallbooks">Go Back</a>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>