package kr.itedu.boardmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.action.Action;
import kr.itedu.boardmvc.action.BoardDeleteAction;
import kr.itedu.boardmvc.action.BoardDetailAction;
import kr.itedu.boardmvc.action.BoardListAction;
import kr.itedu.boardmvc.action.BoardModifyAction;
import kr.itedu.boardmvc.action.BoardRegModAction;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
 
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
        super();
    }

    protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	int image = Utils.getParamInt(request.getParameter("image"));
    
    	if(image == 1) {
			request.setAttribute("content", "image");
			RequestDispatcher rd = request.getRequestDispatcher(Var.TEMPLATE_1);
			rd.forward(request, response);
			
		} else {			
	    	String reqURI = request.getRequestURI();
	    	String ctxPath = request.getContextPath();
	    	String comd = reqURI.substring(ctxPath.length());
	    	
	    	ActionForward forward = null;
	    	Action action = null;
	    	
	    	if(comd.equals("/boardList.bo")) {
	    		action = new BoardListAction();
	    		try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					//TODO: 예외처리
				}
	    		
	    	} else if (comd.equals("/boardDetail.bo")) {
	    		action = new BoardDetailAction();
	    		try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
	    		
	    	} else if(comd.equals("/boardRegMod.bo")) {
	    		action = new BoardRegModAction();
	    		try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
	    	} else if(comd.equals("/boardModify.bo")) {
	    		action = new BoardModifyAction();
	    		try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
	    	} else if(comd.equals("/boardDelete.bo")) {
	    		action = new BoardDeleteAction();
	    		try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
	    	}
	    	
	    	if(forward != null) {
	    		if(forward.isRedirect()) {
	    			response.sendRedirect(forward.getPath());
	    		} else {
	    			RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
	    			rd.forward(request, response);
	    		}
	    	}
		}
    			
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

}
