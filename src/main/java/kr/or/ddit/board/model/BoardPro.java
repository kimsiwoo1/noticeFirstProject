package kr.or.ddit.board.model;

public class BoardPro {
	private int boardNo;
	private String boardNm;
	private String use;
	private String userId;
	private String boardDate;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	@Override
	public String toString() {
		return "BoardPro [boardNo=" + boardNo + ", boardNm=" + boardNm + ", use=" + use + ", userId=" + userId
				+ ", boardDate=" + boardDate + "]";
	}

}
