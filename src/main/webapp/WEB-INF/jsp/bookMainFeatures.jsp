<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/detail.css"/>
	<title>Book Main Features </title>
</head>
<div class="col-1-2">
	<div class="product-wrap">
		<div class="product-shot">
			<img src="${param.productImage}" alt="detailImage" />
		</div>
	</div>
</div>
<div class="col-1-2">
	<div class="product-name">
		<h2>${param.productName}</h2>
	</div>
	<div class="product-price">
		<h3 class="align-left">$${param.productSalePrice}&nbsp;&nbsp;
			<c:if test="${param.productActualPrice ne 0.0}">
				<del>$${param.productActualPrice}</del>
			</c:if>
		</h3>
	</div>
</div>