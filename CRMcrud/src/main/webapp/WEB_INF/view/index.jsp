<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">Customer Relationship Management</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">CustID</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customer }" var="i">
							<tr>
								<th scope="row">${i.id}</th>
								<td>${i.f_name }</td>
								<td>${i.l_name }</td>
								<td>${i.email}</td>
								<td><a href="delete/${i.id }"><i
										class="fa-duotone fa-trash-can text-danger"></i></a> <a
									href="update/${i.id }"><i
										class="fas fa-pen-nib text-primary"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center">
					<a href="add-customer" class="btn btn-outline-success">Add
						Customer</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
