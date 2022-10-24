<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="./base.jsp"%>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title><c:out value="${title}" />Product App</title>
</head>
<body class="">
	<h1 class="container text-center mt-5">Add Product and it's price</h1>
	<div class="container col-md-3 mt-5 border p-2 bg-info">
		<form action="add" method="post">

			<div class="mb-3">
				<label for="name" class="form-label">Product Name</label> <input
					type="text" class="form-control" id="name" name="name">
			</div>

			<div class="mb-3">
				<label for="desc" class="form-label">Product Description</label> 
				<textarea class="w-auto" rows="5" cols="35" id="desc" name="description" style="display: block;"></textarea>
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">Product Price</label> <input
					type="number"  class="form-control" id="price" name="price">
			</div>
			<div class="container text-center d-flex justify-content-evenly">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath }/">Go Back</a>
				<button type="submit" class="btn btn-warning">Submit</button>
			</div>
		</form>

	</div>
</body>
</html>