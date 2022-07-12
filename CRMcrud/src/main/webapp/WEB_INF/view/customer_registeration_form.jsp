<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>

<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the Customer Details</h1>
				<form action="handle-registerCustomer" method="post">
					<div class="form-group">
						<label for="firstname">Customer First Name</label> <input
							type="text" class="form-control" id="firstname"
							aria-describedby="emailhelp" name="firstname"
							placeholder="Enter the customer first name here">
					</div>
					<div class="form-group">
						<label for="lastname">Customer Last Name</label><input type="text"
							class="form-control" id="lastname" name="lastname"
							placeholder="Enter the customer last name here">
					</div>
					<div class="form-group">
						<label for="email">Customer Email</label><input type="text"
							class="form-control" id="email" name="email"
							placeholder="Enter the customer email here">
					</div>
					<div class="container text-center">
						<a href="list_customers" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Add
							Customer</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<h1></h1>
</body>
</html>