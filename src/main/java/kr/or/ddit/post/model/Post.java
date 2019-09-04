package kr.or.ddit.post.model;

public class Post {
	private int postNo;
	private int boardNo;
	private String postNm;
	private String postContents;
	private String userId;
	private String writeDate;
	private int parentPostNo;
	private String del;
	private int gn;
	
	
	public int getGn() {
		return gn;
	}
	public void setGn(int gn) {
		this.gn = gn;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getPostNm() {
		return postNm;
	}
	public void setPostNm(String postNm) {
		this.postNm = postNm;
	}
	public String getPostContents() {
		return postContents;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getParentPostNo() {
		return parentPostNo;
	}
	public void setParentPostNo(int parentPostNo) {
		this.parentPostNo = parentPostNo;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Post [postNo=" + postNo + ", boardNo=" + boardNo + ", postNm=" + postNm + ", postContents="
				+ postContents + ", userId=" + userId + ", writeDate=" + writeDate + ", parentPostNo=" + parentPostNo
				+ ", del=" + del + ", gn=" + gn + "]";
	}
	
	
	
	
}
	

