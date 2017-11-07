<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>POS - Produkty</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale (POS) - Produkty</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p style="text-align:right;">
				<a href="${pageContext.request.contextPath}/panel">Powrót do panelu</a>
			</p>
		
			
			<input type="button" value="Dodaj produkt" 
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button" 
			/>
			
            <form:form action="search" method="POST">
                Szukaj produkt: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Szukaj" class="add-button" />
            </form:form>
		
			
			<table>
				<tr>
					<th>ID</th>
					<th>Nazwa</th>
					<th>Kategoria</th>
					<th>Cena</th>
					<th>Akcja</th>
				</tr>
				
				<c:forEach var="tempProduct" items="${products}">
					
					<c:url var="updateLink" value="/product/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					

					<c:url var="deleteLink" value="/product/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
					<tr>
						<td>${tempProduct.id}</td>
						<td>${tempProduct.name}</td>
						<td>${tempProduct.category.name}</td>
						<td>${tempProduct.price}</td>
						
						<td>

							<a href="${updateLink}">Edytuj</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Czy jesteś pewien, że chcesz usunąć ten produkt?'))) return false">
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