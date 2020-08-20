<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>

<html>

<head>
	<title>Add a customer</title>
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<form:form action="processData" modelAttribute="customer" method="POST" class="form">
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" id="sv-btn"/></td>
				</tr>
		
			</tbody>
		</table>
	
		<a href="list">Back to the list</a>
	</form:form>

</body>



</html>