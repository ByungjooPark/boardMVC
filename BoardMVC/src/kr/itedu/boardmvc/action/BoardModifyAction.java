package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int btype = Utils.getOneParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardListService service = new BoardListService();
		
		service.getBoardModify_S(btype, bid, btitle, bcontent);
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("btype", btype);
		request.setAttribute("content", "boardList");
		
		forward.setRedirect(true);
		forward.setPath(Var.TEMPLATE_2 + "?btype=" + btype);
		
		return forward;
	}

}
