package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.*;
import kr.itedu.boardmvc.common.*;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int btype = Utils.getOneParamInt(request.getParameter("btype"));
		int page_count = Utils.getOneParamInt(request.getParameter("page_count"));
		
		BoardListService service = new BoardListService();
		int total_count = service.getTotalCount_S(btype);
		ArrayList<BoardVO> data = service.getBoardList_S(btype, page_count);
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");	
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("total_count", total_count);
		
		return forward;
	}
	

}
