<%@page import="kr.itedu.boardmvc.BoardVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<BoardVO> result = (ArrayList<BoardVO>)request.getAttribute("data");

%>

<h2>${title } 게시판</h2>
<%
if(result.size() > 0) {
%>
<table>
	<tr>
		<th class="th1">번호</th>
		<th class="th2">제목</th>
		<th class="th3">등록일시</th>
		<th class="th4">수정일시</th>
	</tr>
	<%
	for(int i = 0; i < result.size(); i++) {
	%>
	<tr>		
		<td class="td1"><%=result.get(i).getBid() %></td>
		<td class="td2"><a href="boardDetail.bo?btype=${btype }&bid=<%=result.get(i).getBid() %>"><%=result.get(i).getBtitle() %></a></td>
		<td class="td3"><%=result.get(i).getBregdate() %></td>
		<td class="td3"><%=result.get(i).getBmodifydate() %></td>
	</tr>
	<%	
	}
	%>
</table>

<%
} else {
%>
<h1>게시글 없음</h1>
<%
}
%>
<br>
<a href="boardRegMod.bo?btype=${btype }&bid=0"><input type="button" value="글쓰기"></a>
<br>
&nbsp;&nbsp;
<div class="page_num">
	<c:forEach var="page_count" begin="1" end="${total_count }" step="1">
		<a href="boardList.bo?btype=${btype }&page_count=${page_count}">${page_count }&nbsp;&nbsp;</a>
	</c:forEach>
</div>


