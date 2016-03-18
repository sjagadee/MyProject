package reader;

public class ClassReader {

	String className;
	String professor;
	Integer studentID;

	public ClassReader(String className, String professor, Integer studentID) {
		this.className = className;
		this.professor = professor;
		this.studentID = studentID;
	}
	
	public ClassReader() {
		
	}

	public String getclassName() {
		return className;
	}
	public void setclassName(String className) {
		this.className = className;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	@Override
	public String toString() {
		return "classNameReader [className=" + className + ", professor=" + professor + ", studentID=" + studentID
				+ "]";
	}
	
}
