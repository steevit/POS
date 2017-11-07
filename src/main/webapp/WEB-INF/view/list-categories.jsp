<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>POS - Kategorie</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale (POS) - Kategorie</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p style="text-align:right;">
				<a href="${pageContext.request.contextPath}/panel">Powrót do panelu</a>
			</p>
		
			<!-- utworzenie przycisku: Dodaj kategorię -->
			
			<input type="button" value="Dodaj kategorię" 
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button" 
			/>
			
			   <!--  utworzenie sekcji szukania -->
            <form:form action="search" method="POST">
                Szukaj kategorii: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Szukaj" class="add-button" />
            </form:form>
		
			<!-- utworzenie tabeli wyświetlającej wyniki -->
			
			<table>
				<tr>
					<th>ID</th>
					<th>Nazwa</th>
					<th>Opis</th>
					<th>Akcja</th>
				</tr>
				
				<!-- wyświetlenie wyników -->
				<c:forEach var="tempCategory" items="${categories}">
					
					<!-- utworzenie update linku -->
					<c:url var="updateLink" value="/category/showFormForUpdate">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>
					
					<!-- utworzenie delete linku -->
					<c:url var="deleteLink" value="/category/delete">
						<c:param name="categoryId" value="${tempCategory.id}" />
					</c:url>
					
					<tr>
						<td>${tempCategory.id}</td>
						<td>${tempCategory.name}</td>
						<td>${tempCategory.description}</td>
						
						<td>
							<!-- wyświetlenie utworzonych linków -->
							<a href="${updateLink}">Edytuj</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Czy jesteś pewien, że chcesz usunąć tą kategorię?'))) return false">
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