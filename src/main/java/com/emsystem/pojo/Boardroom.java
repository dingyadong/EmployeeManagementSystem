package com.emsystem.pojo;

public class Boardroom {
	private int boardroomId;
	private String boardroomName;
	private String boardroomUrl;
	private int space;
	private int airCondition;
	public int getBoardroomId() {
		return boardroomId;
	}
	public void setBoardroomId(int boardroomId) {
		this.boardroomId = boardroomId;
	}
	public String getBoardroomName() {
		return boardroomName;
	}
	public void setBoardroomName(String boardroomName) {
		this.boardroomName = boardroomName;
	}
	

	public String getBoardroomUrl() {
		return boardroomUrl;
	}
	public void setBoardroomUrl(String boardroomUrl) {
		this.boardroomUrl = boardroomUrl;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	public int getAirCondition() {
		return airCondition;
	}
	public void setAirCondition(int airCondition) {
		this.airCondition = airCondition;
	}
	@Override
	public String toString() {
		return "Boardroom [boardroomId=" + boardroomId + ", boardroomName=" + boardroomName + ", boardroomUrl="
				+ boardroomUrl + ", space=" + space + ", airCondition=" + airCondition + "]";
	}

}
