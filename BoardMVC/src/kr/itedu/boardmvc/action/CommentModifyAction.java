package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class CommentModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int cid = Utils.getParamInt(request.getParameter("cid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		String c_content = (String)request.getParameter("c_content");
		
		if(cid == -1 || btype == -1 || bid == -1) {
			forward.setPath(Var.ERROR_PAGE);
			
			return forward;
		} else {
			BoardListService service = new BoardListService();
			service.getCommentModify_S(cid, btype, bid, c_content);
			
			request.setAttribute("cid", cid);
			request.setAttribute("btype", btype);
			request.setAttribute("bid", bid);
			request.setAttribute("content", "boardDetail");
			forward.setPath(Var.TEMPLATE_3);
		}
		
		
		
		return forward;
	}

}
