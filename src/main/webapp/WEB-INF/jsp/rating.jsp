<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/detail.css"/>
	<title>Book Rating</title>
</head>
<c:choose>
	<c:when test="${param.rating == 5.0 }">
		<c:forEach var = "i" begin = "1" end = "5">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
	</c:when>
	<c:when test="${param.rating > 4.0 && param.rating < 5.0}">
		<c:forEach var = "i" begin = "1" end = "4">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
		<img src="${assetsUrl}/img/half_star.svg" width="18px" height="18px" alt="halfStar"/>
	</c:when>
	<c:when test="${param.rating == 4.0}">
		<c:forEach var = "i" begin = "1" end = "4">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
		<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
	</c:when>
	<c:when test="${param.rating > 3.0  && param.rating < 4.0}">
		<c:forEach var = "i" begin = "1" end = "3">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
		<img src="${assetsUrl}/img/half_star.svg" width="18px" height="18px" alt="halfStar"/>
		<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
	</c:when>
	<c:when test="${param.rating == 3.0}">
		<c:forEach var = "i" begin = "1" end = "3">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
		<c:forEach var = "i" begin = "1" end = "2">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:when>
	<c:when test="${param.rating > 2.0 && param.rating < 3.0}">
		<c:forEach var = "i" begin = "1" end = "2">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
		<img src="${assetsUrl}/img/half_star.svg" width="18px" height="18px" alt="halfStar"/>
		<c:forEach var = "i" begin = "1" end = "2">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:when>
	<c:when test="${param.rating == 2.0}">
		<c:forEach var = "i" begin = "1" end = "2">
			<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		</c:forEach>
		<c:forEach var = "i" begin = "1" end = "3">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:when>
	<c:when test="${param.rating > 1.0 && param.rating < 2.0}">
		<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		<img src="${assetsUrl}/img/half_star.svg" width="18px" height="18px" alt="halfStar"/>
		<c:forEach var = "i" begin = "1" end = "3">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:when>
	<c:when test="${param.rating == 1.0}">
		<img src="${assetsUrl}/img/full_star.svg" width="18px" height="18px" alt="fullStar"/>
		<c:forEach var = "i" begin = "1" end = "4">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:when>
	<c:when test="${param.rating > 0.0 && param.rating < 1.0}">
		<img src="${assetsUrl}/img/half_star.svg" width="18px" height="18px" alt="halfStar"/>
		<c:forEach var = "i" begin = "1" end = "4">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach var = "i" begin = "1" end = "5">
			<img src="${assetsUrl}/img/empty_star.svg" width="18px" height="18px" alt="emptyStar"/>
		</c:forEach>
	</c:otherwise>
</c:choose>