package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_2);
		
		int btype = Utils.getOneParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		
		BoardListService service = new BoardListService();
		service.getBoardDelete_S(btype, bid);

		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		
		return forward;
	}

}
