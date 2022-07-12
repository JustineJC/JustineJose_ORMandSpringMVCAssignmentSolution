<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="./base.jsp"%>
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
						<c:forEach items="${customers }" var="i">
							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/delete">
								<c:param name="id" value="${i.id}" />
							</c:url>
							<c:url var="updateLink" value="/updateForm">
								<c:param name="id" value="${i.id}" />
							</c:url>
							<tr>
								<th scope="row">${i.id }</th>
								<td>${i.firstname }</td>
								<td>${i.lastname }</td>
								<td>${i.email }</td>
								<td><a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete ?')"><i
										class="fa-solid fa-trash-can text-danger"></i></a> <a
									href="${updateLink}"><i
										class="fas fa-pen-nib text-primary"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="container text-center">
					<a
						href="customer_registeration_form"
						class="btn btn-outline-success">Add Customer</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
