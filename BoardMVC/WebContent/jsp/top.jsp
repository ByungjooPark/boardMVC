<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1 id="top">${title } 게시판</h1>

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
