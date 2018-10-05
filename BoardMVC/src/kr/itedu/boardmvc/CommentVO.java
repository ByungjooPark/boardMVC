package kr.itedu.boardmvc;

public class CommentVO {
	private int cid;
	private int bid;
	private int btype;
	private String t_comment;
	private String cregdate;
	
	public CommentVO(int cid, int bid, int btype, String t_comment, String cregdate) {
		setCid(cid);
		setBid(bid);
		setBtype(btype);
		setT_comment(t_comment);
		setCregdate(cregdate);
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public String getT_comment() {
		return t_comment;
	}
	public void setT_comment(String t_comment) {
		this.t_comment = t_comment;
	}
	public String getCregdate() {
		return cregdate;
	}
	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}
	
	

}
