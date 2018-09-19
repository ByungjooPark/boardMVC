<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String content = (String)request.getAttribute("content");
String title = "";

if(content.equals("boardList")){
	title = "게시판";
} else if (content.equals("image")){
	title = "이미지";
}
%>

<h1><%=title %></h1>

<ul>
	<a href="boardList.bo?image=1"><li>이미지</li></a>
	<li class="dropbox">게시판
		<ul class="dropbox_ul">
			<a href="boardList.bo?btype=0"><li>공지게시판</li></a>
			<a href="boardList.bo?btype=1"><li>자유게시판</li></a>
			<a href="boardList.bo?btype=2"><li>문의게시판</li></a>
		</ul>
	</li>
</ul>
