package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardListService {
	public ArrayList<BoardVO> getBoardList_S(int btype, int page_count) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		
		result = dao.getBoardList(btype, page_count);
		
		return result;
	}
	
	public BoardVO getBoardDetail_S(int btype, int bid) {		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bv = dao.getBoardDetail(btype, bid);
		
		return bv;
	}
	
	public void getBoardModify_S(int btype, int bid, String btitle, String bcontent) {
		BoardDAO dao = BoardDAO.getInstance();
		
		if(bid == 0) {
			dao.getBoardInsert(btype, btitle, bcontent);
		} else if(bid > 0) {
			dao.getBoardUpdate(btype, bid, btitle, bcontent);
		} else {
			//TODO: 업데이트 에러처리
		}
		
	}
	
	public void getBoardDelete_S(int btype, int bid) {
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.getBoardDelete(btype, bid);
	}
	
	public int getTotalCount_S(int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		
		int page_count = dao.getPageCount(btype);		
		
		return page_count;
	}
	
}
