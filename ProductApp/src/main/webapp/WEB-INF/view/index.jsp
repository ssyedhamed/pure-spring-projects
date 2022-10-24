<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value="/resources/css/style.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
</head>
<body>

	<div class="container col-md-10  mt-5">
		<div class="container text-center ">
			<h1 class="text-center">Product CRUD Web Application</h1>
			<small class="text-center">Developed by <a href="https://www.linkedin.com/in/ssyedhamed/" target="_blank">@ssyedhamed</a></small>
			<small class="mt-2" style="display: block;"><i>A pure spring web application designed using spring and hibernate</i></small>
		</div>
		<table class="table table-dark table-striped mt-3 border w-100">
			<thead style="position: sticky;top: 0;z-index:1; display: table-header-group;"  class="border">
				<tr>
					<th scope="col">Id</th>
					<th scope="col" >Product</th>
					<th scope="col" >Description</th>
					<th scope="col" class="w-auto">Price</th>
					<th scope="col" class="w-auto" >Edit</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<th scope="row">100E</th>
					<td>Razor</td>
					<td> A razor is a bladed tool primarily used in the removal of body hair through the act of shaving.[1] Kinds of razors include straight razors, safety razors, disposable razors, and electric razors. While the razor has been in existence since before the Bronze Age (the oldest razor-like object has been dated to 18,000 BC[2]), the most common types of razors currently used are the safety razor and the electric razor. </td>
					<td> &#8377;10000</td>
					<td>you can't change this static data</td>
				</tr>
			<c:forEach items="${products}" var="p" >
			<tr>
					<th scope="row">${p.id}</th>
					<td>${p.name}</td>
					<c:choose>
					
					<c:when test="${p.description=='' }">
						<td>No information added</td>
					</c:when>
					<c:otherwise>
						<td><c:out value="${p.description}"></c:out></td>
					</c:otherwise>					
					</c:choose>
					
					<td>&#8377;${p.price}</td>
					<td class="w-auto"><a href="update/${p.id}" class="text-warning" style="text-decoration: none;">Update</a><span>|</span>
					<a href="delete/${p.id}" class="text-danger" style="text-decoration: none;">Delete</a></td>
				</tr>
</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a href="add-product" class="btn btn-success ">Add Product</a>
		
		</div>
	</div>
</body>
</html>
