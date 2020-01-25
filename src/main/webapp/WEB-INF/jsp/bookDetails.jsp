<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %><%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html lang="en">
	<head>
		<title>Simple Walmart Book Shop</title>
		<meta name="description" content="Simple Walmart Book Shop" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/main.css" />
		<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/detail.css"/>
		<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/review.css"/>
	</head>
	<body>
		<div id="main">
			<jsp:include page="header.jsp" />
			<div id="detail_content">
				<div id="content">
					<div class="book_detail_main_features">
					    <jsp:include page="bookMainFeatures.jsp" >
                             <jsp:param name="productImage" value="${detailOutput.detailImage}" />
                             <jsp:param name="productName" value="${detailOutput.productName}" />
                             <jsp:param name="productSalePrice" value="${detailOutput.salePrice}" />
                             <jsp:param name="productActualPrice" value="${detailOutput.actualPrice}" />
                        </jsp:include>
					</div>

                    <div class="book_detail_description">
                         <jsp:include page="bookDescription.jsp" >
                              <jsp:param name="bookDescription" value="${detailOutput.description}" />
                         </jsp:include>
                    </div>

                    <div class="book_detail_specifications">
                         <jsp:include page="bookSpecifications.jsp" >
                              <jsp:param name="author" value="${detailOutput.author}" />
                              <jsp:param name="upc" value="${detailOutput.upc}" />
                         </jsp:include>
                    </div>

                    <div class="book_reviews_summary">
                         <h3 class="align-left">
                              <span class="section">Customer Reviews</span>
                         </h3>
                         <c:if test="${detailOutput.itemReviews.reviews == null}">
                              <p> Be the first to review this item!</p>
                         </c:if>
                         <c:if test="${detailOutput.itemReviews.reviewStatistics != null}">
                              <div class="review-rating">
                                   <div class="score-rating">
                                       <span class="review-overall-rating">${detailOutput.itemReviews.reviewStatistics.averageOverallRating}</span>
                                   </div>
                                   <div class="book_score_rating">
                                       <span class="score-stars">
                                           <fmt:parseNumber var = "rating" type = "number" value = "${detailOutput.itemReviews.reviewStatistics.averageOverallRating}" />
                                           <jsp:include page="rating.jsp" >
                                                <jsp:param name="rating" value="${rating}" />
                                           </jsp:include>
                                       </span>
                                   </div>
                                   <span>${detailOutput.itemReviews.reviewStatistics.totalReviewCount} reviews</span>
                              </div>
                              <div class="book_review_histogram">
                                  <c:forEach items="${detailOutput.itemReviews.reviewStatistics.ratingDistributions}" var="item" varStatus="itemStatus">
                                       <span style="display:inline">${5-itemStatus.index}&nbsp;stars</span>
                                       <progress style="display:inline" value="${item.count}" max="${detailOutput.itemReviews.reviewStatistics.totalReviewCount}"></progress>
                                          <span style="display:inline">${item.count}</span>
                                  </c:forEach>
                              </div>
                              <br/>
                              <br/>
                              <hr />
                         </c:if>
                    </div>

                    <div class="book_reviews">
                         <c:forEach items="${detailOutput.itemReviews.reviews}" var="review">
                              <div class="review">
                                   <fmt:parseNumber var = "rating" type = "number" value = "${review.overallRating.rating}" />
                                   <jsp:include page="rating.jsp" >
                                        <jsp:param name="rating" value="${rating}"/>
                                   </jsp:include>
                                   <h4 class="book_review_title">&nbsp;${review.title}</h4>
                                   <br/>
                                   <div class="book_review_text">
                                        <em>${review.reviewText}</em>
                                   </div>
                                   <br/>
                                   <div class="book_review_user_date">
                                        <small>${review.reviewer},${review.submissionTime}</small>
                                   </div>
                              </div>
                         </c:forEach>
                     </div>
                </div>
		    </div>
		    <jsp:include page="footer.jsp" />
	    </div>
    </body>
</html>

