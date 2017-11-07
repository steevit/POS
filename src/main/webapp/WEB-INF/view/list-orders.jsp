<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>POS - Zamówienia</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale (POS) - Zamówienia</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<p style="text-align:right;">
				<a href="${pageContext.request.contextPath}/panel">Powrót do panelu</a>
			</p>
		
			
			<input type="button" value="Dodaj zamówienie" 
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button" 
			/>
		
			
			<table>
				<tr>
					<th>ID</th>
					<th>Klient</th>
					<th>Adres</th>
					<th>Telefon</th>
					<th>Produkty</th>
					<th>Ilość</th>
					<th>Kwota</th>
					<th>Data</th>
					<th>Status</th>
					<th>Płatność</th>
					<th>Akcja</th>
				</tr>
				
				<c:forEach var="tempOrder" items="${orders}">
					
					<c:url var="updateLink" value="/order/showFormForUpdate">
						<c:param name="orderId" value="${tempOrder.id}" />
					</c:url>
					
					<c:url var="itemLink" value="/order/showFormForItemAdd">
						<c:param name="orderItemOId" value="${tempOrder.id}" />
					</c:url>
					
					<tr>
						<td>${tempOrder.id}</td>
						<td>${tempOrder.customer.firstName} ${tempOrder.customer.lastName}</td>
						<td>${tempOrder.customer.details.street}, ${tempOrder.customer.details.zip} ${tempOrder.customer.details.city}</td>
						<td>${tempOrder.customer.details.phone}</td>
						<td>
							<c:forEach var="tempItem" items="${tempOrder.items}">
							<c:url var="itemDLink" value="/order/deleteItem">
								<c:param name="orderItemOId" value="${tempItem.order.id}" />
								<c:param name="orderItemPId" value="${tempItem.product.id}" />
							</c:url>
								${tempItem.product.name} - ${tempItem.product.price} - <a href="${itemDLink}">Usuń</a> <br/>
							</c:forEach>
						</td>
						<td><c:forEach var="tempItem" items="${tempOrder.items}">
								${tempItem.quantity}<br/>
							</c:forEach>
						</td>
						<td>${tempOrder.total}</td>
						<td>${tempOrder.date}</td>
						<td>${tempOrder.status.name}</td>
						<td>${tempOrder.payment.name}</td>
						<td>
							<a href="${updateLink}">Edytuj</a>
								<br>
							<a href="${itemLink}">Dodaj produkt</a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		
		</div>
	
	</div>

</body>
</html>