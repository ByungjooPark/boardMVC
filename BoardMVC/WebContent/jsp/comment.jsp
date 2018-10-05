<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.itedu.boardmvc.*"%>
<%@ page import="java.util.ArrayList"%>
    
<%
ArrayList<CommentVO> arr_cv = (ArrayList<CommentVO>)request.getAttribute("arr_data");
%>    
    
<div class="comment_box">
	<form action="commentModify.bo" method="post">
		<table>
			<%for(int i = 0; i <arr_cv.size(); i++) { %>
				<tr>
					<td><%=arr_cv.get(i).getCregdate() %></td>
					<td class="com_del">
						<a href="commentDelete.bo?cid=<%=arr_cv.get(i).getCid() %>&btype=<%=arr_cv.get(i).getBtype() %>&bid=<%=arr_cv.get(i).getBid() %>"><input type="button" value="댓글삭제"/></a>
					</td>
				</tr>				
				<tr class="tr_comment">
					<td colspan="2"><%=arr_cv.get(i).getT_comment() %></td>		
				</tr>
			<%
			}
			%>
			
		</table>
		<br>
		<br>
		<div class="textarea_box">
			<textarea name="c_content" rows="5" cols="100"></textarea>
			<input type="hidden" name="cid" value="0">
			<input type="hidden" name="btype" value="${btype }">
			<input type="hidden" name="bid" value="${bid }">
			<input type="submit" value="등록">
		</div>
	</form>
</div>