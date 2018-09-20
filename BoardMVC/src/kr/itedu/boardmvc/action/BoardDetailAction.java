package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int btype = Utils.getOneParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		
		BoardListService service = new BoardListService();
		BoardVO bv = service.getBoardDetail_S(btype, bid);
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("btype", btype);
		request.setAttribute("bid", bid);
		request.setAttribute("content", "boardDetail");
		request.setAttribute("data", bv);
		
		return forward;
	}

}
