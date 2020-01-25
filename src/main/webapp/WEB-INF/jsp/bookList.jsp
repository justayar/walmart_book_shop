<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Simple Walmart Book Shop</title>
		<meta name="description" content="Simple Walmart Book Shop" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/main.css" />
		<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/booklist.css" />
		<script type="text/javascript" src="${assetsUrl}/js/main.js"></script>
	</head>
	<body>
		<div id="main">
			<jsp:include page="header.jsp" />
			<div id="site_content">
				<div id="main_content">
					<div id="book_list_container">
						<c:set var="openedPageIndex" value="${listOutput.openedPageNum}" />
						<c:forEach items="${listOutput.pageItemsBeanList}" var="pageItemList" varStatus="counter">
                            <div class="book_list_single_line_items" style="${counter.index != openedPageIndex ? 'display: none' : 'display: block'}">
                                <c:forEach items="${pageItemList.pageItems}" var="item" varStatus="itemStatus">
                                    <c:if test="${itemStatus.index % 4 == 0 && itemStatus.index != 0}">
                                        <hr>
                                    </c:if>
                                    <div class="book_list_item" onClick="openDetail(${item.itemId})">
                                            <img src="${item.mediumImage}" alt="mediumImage"/>
                                            <h2 class="book_product_name">${fn:substring(item.name,0, 40)}</h2>
                                            <h3 class="book_product_price">$${item.salePrice}</h3>
                                    </div>
                                </c:forEach>
                            </div>
						</c:forEach>
					</div>
					<div id="pagination">
						<c:set var="openedPageIndex" value="${listOutput.openedPageNum}" />
						<img class="prev" onclick="goToPreviousPage()" src="${assetsUrl}/img/paginator_prev.svg" alt="prevButton" width="30px" height="30px"
                              style="visibility:hidden"/>
						<c:forEach begin="${openedPageIndex+1}" end="${openedPageIndex+10}" varStatus="loop">
							<a class="page-numbers" onclick="openAnotherPage(${loop.index})">${loop.index}</a>
						</c:forEach>
						<img class="next" onclick="goToNextPage()" src="${assetsUrl}/img/paginator_next.svg" alt="nextButton" width="30px" height="30px"/>
				    </div>
				</div>
			</div>
			<jsp:include page="footer.jsp" />
	    </div>
	</body>
</html>