package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardRegModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
				
		System.out.println(request.getParameter("btype"));
		System.out.println(request.getParameter("bid"));
		
		int btype = Utils.getOneParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		
		
		if(bid == 0) {
			request.setAttribute("btitle", "");
			request.setAttribute("bcontent", "");
		} else {
			BoardListService service = new BoardListService();
			BoardVO bv = service.getBoardDetail_S(btype, bid);
			
			request.setAttribute("btitle", bv.getBtitle());
			request.setAttribute("bcontent", bv.getBcontent());
			
		}
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardRegMod");
		request.setAttribute("btype", btype);
		request.setAttribute("bid", bid);
		
		return forward;
	}

}
