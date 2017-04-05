package students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Collections;
import java.util.Map;

public class StudentDatabase{
	int assignment;
	
	private List<Students> student = new ArrayList<Students>();
	private List<Students> assignments = new ArrayList<Students>();
	private Map<Students, String> grades = new HashMap<Students, String>();
	
	private void loadStudents(){
		student.add(new Students("Dylan Jeffery", "first", 100));
	}
	
	public void list(){
		for(Students x : student){
			System.out.println(x);
		}
	}
	
	public static void main(String[] argz){
		StudentDatabase sdb = new StudentDatabase();
		sdb.loadStudents();
		sdb.list();
	}
}
