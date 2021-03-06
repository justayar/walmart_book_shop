<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<link rel="stylesheet" type="text/css" href="${assetsUrl}/css/detail.css"/>
	<title> Book Specifications</title>
</head>
<h3 class="align-left">
	<span class="section">Specifications</span>
</h3>
<table class="specTable">
	<tbody>
         <tr>
            <td>Author</td>
            <td>${param.author}</td>
         </tr>
         <tr>
             <td>Unique Product Code</td>
             <td>${param.upc}</td>
         </tr>
         <tr>
             <td>Online Availability</td>
             <td>${param.availableOnline}</td>
         </tr>
         <tr>
             <td>Offer Type</td>
             <td>${param.offerType}</td>
         </tr>
	</tbody>
</table>