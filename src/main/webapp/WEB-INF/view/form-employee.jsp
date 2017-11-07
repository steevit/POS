<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Zapisz pracownika</title>
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
			<h2>Point Of Sale (POS) - Pracownicy</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz pracownika</h3>
		
		<form:form action="saveEmployee" modelAttribute="employee" method="POST">
		
			<form:hidden path="id" />
			
			<table>
			
				<tbody>
					
					<tr>
						<td><label>Imię:</label></td>
						<td>
							<form:input path="fName" />
							<form:errors path="fName" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Nazwisko:</label></td>
						<td>
							<form:input path="lName" />
							<form:errors path="lName" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td>
							<form:input path="email" />
							<form:errors path="email" cssClass="error" />
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
			<a href="${pageContext.request.contextPath}/employee/list">Powrót do listy</a>
		</p>
		
	</div>

</body>
</html>