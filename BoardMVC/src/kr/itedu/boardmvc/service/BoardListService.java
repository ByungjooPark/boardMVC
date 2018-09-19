package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardListService {
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		
		result = dao.getBoardList(btype);
		
		return result;
	}
	
	public BoardVO getBoardDetail(int btype, int bid) {		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bv = dao.getBoardDetail(btype, bid);
		
		return bv;
	}
	
	public ArrayList<BoardVO> getBoardInsert(int btype, int bid, String btitle, String bcontent) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		
		if(bid == 0) {
			dao.getBoardInsert(btype, btitle, bcontent);
		}		
		
		result = dao.getBoardList(btype);
		
		return result;
		
	}
}
