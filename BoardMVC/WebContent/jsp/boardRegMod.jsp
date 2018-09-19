<%@page import="kr.itedu.boardmvc.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>>


<h2>${title } 게시판</h2>

<div class="container">
	<form action="boardModify.bo" method="post">
		<label>
			<h2>제목 </h2><input type="text" name="btitle" value="${btitle }">
		</label>
		<label>
			<h2>글 </h2>
			<textarea rows="10" cols="60" name="bcontent">${bcontent }</textarea>
		</label><br>		
		<input type="hidden" name="btype" value="${btype }">
		<input type="hidden" name="bid" value="${bid}">
		<input type="submit" value="완료">
	</form>
</div>
