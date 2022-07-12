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
				<h1 class="text-center mb-3">Update Customer Details</h1>
				<form action="handle-updateCustomer"
					method="post">
					<input type="hidden" value="${customer.id}" name="id" />
					<div class="form-group">
						<label for="firstname">Student first Name</label> <input type="text"
							class="form-control" id="firstname" aria-describedby="emailhelp"
							name="firstname" placeholder="update the customer first name here"
							value="${customer.firstname }">
					</div>
					<div class="form-group">
						<label for="lastname">Customer Last Name</label><input
							type="text" class="form-control" id="lastname"
							name="lastname"
							placeholder="update the customer last name here"
							value="${customer.lastname}">
					</div>
					<div class="form-group">
						<label for="email">Student email</label><input type="text"
							class="form-control" id="email" name="email"
							placeholder="update the customer email here"
							value="${customer.email}">
					</div>
					<div class="container text-center">
						<a href="list_customers"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-warning">Update
							</button>
					</div>



				</form>

			</div>
		</div>
	</div>
	<h1></h1>
</body>
</html>