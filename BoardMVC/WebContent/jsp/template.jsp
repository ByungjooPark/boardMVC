<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Template</title>

<link rel="stylesheet" type="text/css" href="css/common.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/top.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/${content }.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/bottom.css?ver=1">

</head>
<body>
	<jsp:include page="top.jsp"/>
	
	<div class="container">
		<jsp:include page="${content }.jsp"/>
	</div>
	
	<jsp:include page="bottom.jsp"/>


</body>
</html>