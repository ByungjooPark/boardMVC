package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int btype = Utils.getBtypeParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		String btitle = (String)request.getAttribute("btitle");
		String bcontent = (String)request.getAttribute("bcontent");
		
		System.out.println(btitle);
		System.out.println(bcontent);
		
		BoardListService service = new BoardListService();
		ArrayList<BoardVO> data = service.getBoardInsert(btype, bid, btitle, bcontent);
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("btype", btype);
		request.setAttribute("bid", bid);
		request.setAttribute("content", "boardList");
		request.setAttribute("data", data);
		
		return forward;
	}

}
