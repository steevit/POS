<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Zapisz magazyn</title>
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
			<h2>Point Of Sale (POS) - Magazyny</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz magazyn</h3>
		
		<form:form action="saveStorehouse" modelAttribute="storehouse" method="POST">
		
			<form:hidden path="id" />
			
			<table>
			
				<tbody>
				
					<tr>
						<td><label>Nazwa:</label></td>
						<td>
							<form:input path="name" />
							<form:errors path="name" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Telefon:</label></td>
						<td>
							<form:input path="phone" />
							<form:errors path="phone" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Ulica:</label></td>
						<td>
							<form:input path="street" />
							<form:errors path="street" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Kod Pocztowy:</label></td>
						<td>
							<form:input path="zip" />
							<form:errors path="zip" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Miasto:</label></td>
						<td>
							<form:input path="city" />
							<form:errors path="city" cssClass="error" />
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
			<a href="${pageContext.request.contextPath}/storehouse/list">Powrót do listy</a>
		</p>
		
	</div>

</body>
</html>