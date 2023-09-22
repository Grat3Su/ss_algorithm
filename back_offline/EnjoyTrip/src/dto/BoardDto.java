package dto;

public class BoardDto {
	int index;
	String title, time, userId, detail;
	public BoardDto() {
		super();
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BoardDto(int index, String title, String time, String userId, String detail) {
		super();
		this.index = index;
		this.title = title;
		this.time = time;
		this.userId = userId;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "BoardDto [index=" + index + ", title=" + title + ", time=" + time + ", userId=" + userId + ", detail="
				+ detail + "]";
	}
}
