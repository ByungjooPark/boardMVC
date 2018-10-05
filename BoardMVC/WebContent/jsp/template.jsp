<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Template</title>

<link rel="stylesheet" type="text/css" href="css/common.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/top.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/${content }.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/bottom.css?ver=1">
<c:if test="${content eq 'boardDetail' }">
<link rel="stylesheet" type="text/css" href="css/comment.css?ver=1">
</c:if>

</head>
<body>
	<jsp:include page="top.jsp"/>
	
	<div class="container">
		<jsp:include page="${content }.jsp"/>
		<br><br>
	</div>
	
	<jsp:include page="bottom.jsp"/>


</body>
</html>