package kr.or.ddit.write.model;

public class Write {
	private int commentNo;
	private String contents;
	private String writer;
	private String writeDate;
	private int postNo;
	private String userId;
	private String del;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Write [commentNo=" + commentNo + ", contents=" + contents + ", writer=" + writer + ", writeDate="
				+ writeDate + ", postNo=" + postNo + ", userId=" + userId + ", del=" + del + "]";
	}
	
	
}
