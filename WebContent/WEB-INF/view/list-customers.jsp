<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>List of customers</title>
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
		<input type="button" value="Add Customer" 
		onclick="window.location.href='showFormAdd'; return false;" class="add-button"/>
	<div id="search-bar">
		<form:form action="searchCustomer" method="GET">
			<input type="text" name="string"/>
			<input type="submit" value="Search for Customer" class="search-button"/>
		</form:form>
	</div>
	<div id="container">
		<div id="content">
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				    <th>Email</th>
				    <th>Action</th>
				</tr>
				
				<c:forEach var="temp" items="${customers}">
				<c:url	var="updateLink" value="/customer/showFormUpdate">
					<c:param name="customerId" value="${temp.id}"/>
				</c:url>
				<c:url	var="deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value="${temp.id}"/>
				</c:url>
					<tr>
						<td>${temp.firstName}</td>
					
						<td>${temp.lastName}</td>
					
						<td>${temp.email}</td>
						
						<td>
						
							<!-- display the update link -->
							<a href="${updateLink}">update</a>
							<a>|</a>
							<a href="${deleteLink}"
							onclick="if (!(confirm('Please no, no, no!'))) return false" >delete</a>
						</td>
					</tr>
				
				</c:forEach>
			
			</table>
		
		
		</div>
	</div>

</body>

</html>