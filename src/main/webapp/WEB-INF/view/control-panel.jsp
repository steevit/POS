<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>POS - Panel</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/fontello.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Point Of Sale (POS) - Panel</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="menu">
			<a href="${pageContext.request.contextPath}/customer/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">KLIENCI</p>
                    <i class="icon-user" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/product/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">PRODUKTY</p>
                    <i class="icon-basket" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/order/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">ZAMÓWIENIA</p>
                    <i class="icon-list-alt" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/category/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">KATEGORIE</p>
                    <i class="icon-th-list" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/status/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">STATUSY</p>
                    <i class="icon-info" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/payment/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">PŁATNOŚCI</p>
                    <i class="icon-dollar" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/storehouse/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">MAGAZYNY</p>
                    <i class="icon-warehouse" style="margin-left: 15px;"></i>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/employee/list">
				<div class="menu-item">
                    <p style="text-align: center; font-size: 28px; margin-top: 15px; margin-bottom: 15px;">PRACOWNICY</p>
                    <i class="icon-users" style="margin-left: 15px;"></i>
                </div>
            </a>
		</div>
	
	</div>

</body>
</html>