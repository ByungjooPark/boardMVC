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
		BoardListService service = new BoardListService();
		
		int cid = Utils.getParamInt(request.getParameter("cid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		
		if(cid == -1 || btype == -1 || bid == -1) {
			forward.setPath(Var.ERROR_PAGE);
			
			return forward;
		} else if(cid == 0) {
			service.getCommentDelete_S(cid, btype, bid);
			service.getBoardDelete_S(btype, bid);
			request.setAttribute("title", Var.TITLES[btype]);
			request.setAttribute("content", "boardList");
			request.setAttribute("btype", btype);
			forward.setRedirect(true);
			forward.setPath(Var.TEMPLATE_2 + "?btype=" + btype);
		} 
		
		
		
		return forward;
	}

}
