<%@page import="kr.itedu.boardmvc.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardVO bv = (BoardVO)request.getAttribute("data");
%>

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
			<a href="boardDelete.bo?cid=0&btype=${btype }&bid=${bid }"><input type="submit" value="삭제"></a>				
		</div>
		<div class="button">
			<a href="boardRegMod.bo?cid=0&btype=${btype }&bid=${bid }"><input type="submit" value="수정"></a>
		</div>
	</nav>
	<br><br>
	
		<jsp:include page="comment.jsp"/>
</div>
