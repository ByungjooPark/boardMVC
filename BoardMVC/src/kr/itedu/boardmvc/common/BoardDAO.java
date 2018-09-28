package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.close;
import static kr.itedu.boardmvc.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.RE;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;
	
	//private 생성자
	private BoardDAO() {
		
	}
	
	//싱글톤 패턴
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		
		return dao;
	}

	public ArrayList<BoardVO> getBoardList(int btype, int page_count) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		final int INDEX_COUNT = 10;
		int low_count = ((page_count-1) * INDEX_COUNT) + 1;
		int high_count = page_count * INDEX_COUNT;
		String str;
		
		if(btype == 0) {
			str = "notice";
		} else if(btype == 1) {
			str = "free";
		} else {
			str = "inquiry";
		}
		 
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		
		String sql = " Select * " 
					+ " from( " 
					+ "  		select rownum as rnum, z.* " 
					+ "        from ( " 
					+ "                select * " 
					+ "                from " + str + "_board " 
					+ "                order by bid desc " 
					+ "            ) z where rownum <= " + high_count 
					+ ") where rnum >= " + low_count ;
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO bv = new BoardVO(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bregdate"), rs.getString("bmodifydate"));
				result.add(bv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 예외처리
		} catch(Exception e) {
			e.printStackTrace();
			//TODO: 예외처리
		} finally {
			close(conn, ps, rs);
		}
		
		return result;
	}
	
	public BoardVO getBoardDetail(int btype, int bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO bv = new BoardVO();
		String str;
		
		if(btype == 0) {
			str = "notice";
		} else if(btype == 1) {
			str = "free";
		} else {
			str = "inquiry";
		}
		
		String sql = " select bid, btitle, bcontent, " +
				" to_char(bregdate, 'yyyy-mm-dd hh24:mi:ss') as bregdate " +
				" from " + str + "_board " +
				" where bid = ? ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				bv.setBid(rs.getInt("bid"));
				bv.setBtitle(rs.getString("btitle"));
				bv.setBcontent(rs.getString("bcontent"));
				bv.setBregdate(rs.getString("bregdate"));
			}
									
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 예외처리
		} catch(Exception e) {
			e.printStackTrace();
			//TODO: 예외처리
		} finally {
			close(conn, ps, rs);
		}		
		
		return bv;
	}
		
	public BoardVO getBoardInsert(int btype, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement ps = null;
		String str;
		
		if(btype == 0) {
			str = "notice";
		} else if(btype == 1) {
			str = "free";
		} else {
			str = "inquiry";
		}
		
		String sql = " insert into " + str + "_board "
				 + " (bid, btitle, bcontent, bmodifydate) "
				 + " values "
				 + " ((select nvl(max(bid), 0)+1 from " + str + "_board), ?, ?, sysdate) ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 예외처리
		} catch(Exception e) {
			e.printStackTrace();
			//TODO: 예외처리
		} finally {
			close(conn, ps);
		}	
		
		return null;
	}
	 
	public void getBoardUpdate(int btype, int bid, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement ps = null;
		String str;
		
		if(btype == 0) {
			str = "notice";
		} else if(btype == 1) {
			str = "free";
		} else {
			str = "inquiry";
		}
		
		String sql = " update " + str + "_board "
					+ " set "
				    + " btitle = ?, bcontent = ?, bmodifydate = sysdate "
				    + " where bid = ? ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, bid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 예외처리
		} catch(Exception e) {
			e.printStackTrace();
			//TODO: 예외처리
		} finally {
			close(conn, ps);
		}	
	}
	
	public void getBoardDelete(int btype, int bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String str;
		
		if(btype == 0) {
			str = "notice";
		} else if(btype == 1) {
			str = "free";
		} else {
			str = "inquiry";
		}
		
		String sql = " delete from " + str + "_board "
				+ " where bid = ? ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 예외처리
		} catch(Exception e) {
			e.printStackTrace();
			//TODO: 예외처리
		} finally {
			close(conn, ps);
		}	
	}
	
	public int getPageCount(int btype) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		final int INDEX_COUNT = 10;
		int page_count = -1;
		String str;
		
		if(btype == 0) {
			str = "notice";
		} else if(btype == 1) {
			str = "free";
		} else {
			str = "inquiry";
		}
		
		String sql = " select ceil(count(bid)/?) as total_count " + 
				" from " + str + "_board " ;
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, INDEX_COUNT);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				page_count = rs.getInt("total_count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 예외처리
		} catch(Exception e) {
			e.printStackTrace();
			//TODO: 예외처리
		} finally {
			close(conn, ps);
		}	
				
		return page_count;
	}
}
