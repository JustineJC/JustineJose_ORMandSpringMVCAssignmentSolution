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
				<form action="${pageContext.request.contextPath }/handle-customer"
					method="post">
					<input type="text" value="${customer.id}" name="id" />
					<div class="form-group">
						<label for="f_name">Student first Name</label> <input type="text"
							class="form-control" id="f_name" aria-describedby="emailhelp"
							name="f_name" placeholder="update the customer name here"
							value="${customer.f_name }">
					</div>
					<div class="form-group">
						<label for="department">Customer Last Name</label><input
							type="text" class="form-control" id="l_name"
							name="l_name"
							placeholder="update the customer last name here"
							value="${student.l_name}">
					</div>
					<div class="form-group">
						<label for="email">Student email</label><input type="text"
							class="form-control" id="email" name="email"
							placeholder="update the customer email here"
							value="${student.email}">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Update
							Customer</button>
					</div>



				</form>

			</div>
		</div>
	</div>
	<h1></h1>
</body>
</html>