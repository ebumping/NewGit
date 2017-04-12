package students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Collections;
import java.util.Map;

public class StudentDatabase{
	int grade;
	
	public List<Students> students = new ArrayList<Students>();
	public List<Assignment> assignments = new ArrayList<Assignment>();
	public Map<Students, String> grades = new HashMap<Students, String>();
	
	public void loadStudents(){
		students.add(new Students("Dylan Jeffery", "first", 100));
		assignments.add(new Assignment("Dylan", "first", 100));
	}
	
	public void addStudent(Students student,Assignment assignment)throws Exception{
		if (student.getsID().isEmpty() && student.getAssignment().isEmpty()){
			throw new Exception ("Student and assignment are required fields");
		}else if(grade > 100){
			throw new Exception ("100 is the maximum score for a grade");
		}else{
			students.add(student);
			assignments.add(assignment);
		}
	}
	
	public void listStudents(){
		for(Students x : students){
				System.out.println(x);
		}
	}
	
	public void listAssignments(){
		for(Assignment s : assignments){
			System.out.println(s);
		}
	}
	
	public static void main(String[] argz){
		StudentDatabase sdb = new StudentDatabase();
		sdb.loadStudents();
		//sdb.listStudents();
		sdb.listAssignments();
	}
}
