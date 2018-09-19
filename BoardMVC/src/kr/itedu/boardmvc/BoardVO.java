package kr.itedu.boardmvc;

public class BoardVO {
	private int bid;
	private String btitle, bcontent, bregdate, bmodifydate;
	
	public BoardVO() {
		
	}	
	public BoardVO(int bid, String btitle, String bregdate, String bmodifydate){
		this(bid, btitle, null, bregdate, bmodifydate);
	}
	public BoardVO(String btitle, String bcontent, String bregdate, String bmodifydate){
		this(0, btitle, bcontent, bregdate, bmodifydate);
	}
	
	public BoardVO(int bid, String btitle, String bcontent, String bregdate, String bmodifydate){
		setBid(bid);
		setBtitle(btitle);
		setBcontent(bcontent);
		setBregdate(bregdate);
		setBmodifydate(bmodifydate);
	}

	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBregdate() {
		return bregdate;
	}

	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}
	public String getBmodifydate() {
		return bmodifydate;
	}
	public void setBmodifydate(String bmodifydate) {
		this.bmodifydate = bmodifydate;
	}
	

	
}
