package dto;

public class StudentDto {
	private int studentId;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentNM() {
		return studentNM;
	}
	public void setStudentNM(String studentNM) {
		this.studentNM = studentNM;
	}
	public StudentDto(int studentId, String studentNM) {
		super();
		this.studentId = studentId;
		this.studentNM = studentNM;
	}
	private String studentNM;
}
