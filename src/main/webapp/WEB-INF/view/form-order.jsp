<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Zapisz zamówienie</title>
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
			<h2>Point Of Sale (POS) - Zamówienia</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz zamówienie</h3>
		
		<form:form action="saveOrder" modelAttribute="order" method="POST">
		
			<form:hidden path="id" />
			
			<table>
			
				<tbody>
				
					<tr>
						<td><label>ID klienta:</label></td>
						<td>
							<form:input path="customer.id" />
							<form:errors path="customer.id" cssClass="error" />
						</td>
					</tr>
					
					<tr>
						<td><label>Data:</label></td>
						<td style="color: #444;">			
							${order.date}
						</td>
						<td>
							<fmt:formatDate value="${date}" var="dateString" pattern="yyyy-MM-dd" />
							<form:hidden path="date" value="${dateString}" />
						</td>
					</tr>
					
					<tr>
						<td><label>Status:</label></td>
						<td>
							<form:select path="statusName">
								<c:forEach items="${statuses}" var="s">
									<c:choose>
										<c:when test="${s eq order.status.name}">
											<option value="${s}" selected="true">${s}</option>
										</c:when>
										<c:otherwise>
											<option value="${s}">${s}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
							<form:errors path="statusName" cssClass="error" />
						</td>
						<c:if test= "${order.status != null}">
						<td class="error">
							Obecna wartość: ${order.status.name}
						</td>
						</c:if>
					</tr>
					
					<tr>
						<td><label>Płatność:</label></td>
						<td>
							<form:select path="paymentName">
								<c:forEach items="${payments}" var="p">
									<c:choose>
										<c:when test="${p eq order.payment.name}">
											<option value="${p}" selected="true">${p}</option>
										</c:when>
										<c:otherwise>
											<option value="${p}">${p}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
							<form:errors path="paymentName" cssClass="error" />
						</td>
						<c:if test= "${order.payment != null}">
						<td class="error">
							Obecna wartość: ${order.payment.name}
						</td>
						</c:if>
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
			<a href="${pageContext.request.contextPath}/order/list">Powrót do listy</a>
		</p>
		
	</div>

</body>
</html>