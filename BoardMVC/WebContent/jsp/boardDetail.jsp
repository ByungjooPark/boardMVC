<%@page import="kr.itedu.boardmvc.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardVO bv = (BoardVO)request.getAttribute("data");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
<link rel="stylesheet" type="text/css" href="css/common.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/boardDetail.css?ver=1">
</head>
<body>
	<div class="container">
		<h1>${title } 게시판</h1>
		
		<h2><%=bv.getBtitle() %></h2>		
		<table>
			<tr>
				<th><h2>내용</h2></th>
			</tr>
			<tr>
				<td><%=bv.getBcontent() %></td>
			</tr>
			<tr>
				<th><h2>개시일자</h2></th>
			</tr>
			<tr>
				<td><%=bv.getBregdate() %></td>
			</tr>		
		</table>
		<nav>
			<div class="button">
				<a href="#?btype=${btype }&bid=${bid }"><input type="submit" value="삭제"></a>				
			</div>
			<div class="button">
				<a href="boardRegMod.bo?btype=${btype }&bid=${bid }"><input type="submit" value="수정"></a>
			</div>
		</nav>
		
	</div>
</body>
</html>