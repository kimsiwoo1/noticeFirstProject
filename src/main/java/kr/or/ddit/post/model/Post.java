package kr.or.ddit.post.model;

public class Post {
	private int postno;
	private int boardno;
	private String postnm;
	private String postcontents;
	private String userid;
	private String writedate;
	private int parentpostno;
	private String del;
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getPostnm() {
		return postnm;
	}
	public void setPostnm(String postnm) {
		this.postnm = postnm;
	}
	public String getPostcontents() {
		return postcontents;
	}
	public void setPostcontents(String postcontents) {
		this.postcontents = postcontents;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getParentpostno() {
		return parentpostno;
	}
	public void setParentpostno(int parentpostno) {
		this.parentpostno = parentpostno;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	
	@Override
	public String toString() {
		return "Post [postno=" + postno + ", boardno=" + boardno + ", postnm=" + postnm + ", postcontents="
				+ postcontents + ", userid=" + userid + ", writedate=" + writedate + ", parentpostno=" + parentpostno
				+ ", del=" + del + "]";
	}
	
}
