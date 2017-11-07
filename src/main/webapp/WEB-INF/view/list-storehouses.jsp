<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>POS - Magazyny</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale (POS) - Magazyny</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p style="text-align:right;">
				<a href="${pageContext.request.contextPath}/panel">Powrót do panelu</a>
			</p>
			
			
			<input type="button" value="Dodaj magazyn" 
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button" 
			/>
			
            <form:form action="search" method="POST">
                Szukaj magazyn: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Szukaj" class="add-button" />
            </form:form>
		
			
			<table>
				<tr>
					<th>ID</th>
					<th>Nazwa</th>
					<th>Telefon</th>
					<th>Adres</th>
					<th>Akcja</th>
				</tr>
				
				<c:forEach var="tempStorehouse" items="${storehouses}">
				
					<c:url var="updateLink" value="/storehouse/showFormForUpdate">
						<c:param name="storehouseId" value="${tempStorehouse.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/storehouse/delete">
						<c:param name="storehouseId" value="${tempStorehouse.id}" />
					</c:url>
					
					<tr>
						<td>${tempStorehouse.id}</td>
						<td>${tempStorehouse.name}</td>
						<td>${tempStorehouse.phone}</td>
						<td>${tempStorehouse.street}, ${tempStorehouse.zip} ${tempStorehouse.city}</td>
						
						<td>
							<a href="${updateLink}">Edytuj</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Czy jesteś pewien, że chcesz usunąć ten magazyn?'))) return false">
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