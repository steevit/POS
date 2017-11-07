<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Zapisz status</title>
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
			<h2>Point Of Sale (POS) - Statusy</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz status</h3>
		
		<form:form action="saveStatus" modelAttribute="status" method="POST">
		
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
						<td><label>Opis:</label></td>
						<td>
							<form:textarea path="description" />
							<form:errors path="description" cssClass="error" />
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
			<a href="${pageContext.request.contextPath}/status/list">Powrót do listy</a>
		</p>
		
	</div>

</body>
</html>