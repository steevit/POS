<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Zapisz klienta</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale - Klienci</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz klienta</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
			<form:hidden path="id" />
			<form:hidden path="details.id" />
			
			<table>
			
				<tbody>
				
					<tr>
						<td><label>Imię:</label></td>
						<td>
							<form:input path="firstName" />
							<form:errors path="firstName" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Nazwisko:</label></td>
						<td>
							<form:input path="lastName" />
							<form:errors path="lastName" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td>
							<form:input path="details.email" />
							<form:errors path="details.email" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Telefon:</label></td>
						<td>
							<form:input path="details.phone" />
							<form:errors path="details.phone" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Ulica:</label></td>
						<td>
							<form:input path="details.street" />
							<form:errors path="details.street" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Kod Pocztowy:</label></td>
						<td>
							<form:input path="details.zip" />
							<form:errors path="details.zip" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Miasto:</label></td>
						<td>
							<form:input path="details.city" />
							<form:errors path="details.city" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Zapisz" class="save" /></td>
					</tr>
					
				</tbody>
			
			</table>
		
		</form:form>
		
		<div style="clear:both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Powrót do listy</a>
		</p>
		
	</div>

</body>
</html>