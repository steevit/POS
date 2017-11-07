<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PL" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Zapisz produkt</title>
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
			<h2>Point Of Sale (POS) - Produkty</h2>
		</div>
	</div>

	<div id="container">
		<h3>Zapisz produkt</h3>
		
		<form:form action="saveProduct" modelAttribute="product" method="POST">
		
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
						<td><label>Kategoria:</label></td>
						<td>
							<form:select path="categoryName">
								<c:forEach items="${categories}" var="c">
									<c:choose>
										<c:when test="${c eq product.category.name}">
											<option value="${c}" selected="true">${c}</option>
										</c:when>
										<c:otherwise>
											<option value="${c}">${c}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
							<form:errors path="categoryName" cssClass="error" />
						</td>
						<c:if test= "${product.category != null}">
						<td class="error">
							Obecna wartość: ${product.category.name}
						</td>
						</c:if>
					</tr>
					
					<tr>
						<td><label>Cena:</label></td>
						<td>
							<form:input path="price" />
							<form:errors path="price" cssClass="error" />
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
			<a href="${pageContext.request.contextPath}/product/list">Powrót do listy</a>
		</p>
		
	</div>

</body>
</html>