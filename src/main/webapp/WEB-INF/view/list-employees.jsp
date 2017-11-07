<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>POS - Pracownicy</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale (POS) - Pracownicy</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p style="text-align:right;">
				<a href="${pageContext.request.contextPath}/panel">Powrót do panelu</a>
			</p>
			
			
			<input type="button" value="Dodaj pracownika" 
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button" 
			/>
			
            <form:form action="search" method="POST">
                Szukaj pracownika: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Szukaj" class="add-button" />
            </form:form>
		
			
			<table>
				<tr>
					<th>ID</th>
					<th>Imię i nazwisko</th>
					<th>Email</th>
					<th>Akcja</th>
				</tr>
				
				<c:forEach var="tempEmployee" items="${employees}">
				
					<c:url var="updateLink" value="/employee/showFormForUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>
					
					<tr>
						<td>${tempEmployee.id}</td>
						<td>${tempEmployee.fName} ${tempEmployee.lName}</td>
						<td>${tempEmployee.email}</td>
						
						<td>
							<a href="${updateLink}">Edytuj</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Czy jesteś pewien, że chcesz usunąć tego pracownika?'))) return false">
								Usuń
							</a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>
</html>