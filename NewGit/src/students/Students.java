package students;

public class Students {
	private String sID;
	private String assignment;
	private int grade;
	
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Students(String sID){
		this.sID = sID;
	}
	public Students(String sID, String assignment){
		this.sID = sID;
		this.assignment = assignment;
	}
	
	public Students(String sID, String assignment, int grade){
		this.sID = sID;
		this.assignment = assignment;
		this.grade = grade;
	}
	
	public String toString(){
		return "Student: " + sID + " Assignment : " + assignment + " Grade: " + grade;
	}
}
