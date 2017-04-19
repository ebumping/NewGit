package student.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDB {
	public List<String> students = new ArrayList<String>();
	public Map<String, String> assignment = new HashMap<String, String>();
	public Map<Map<String, String>, Integer> grades = new HashMap<Map<String, String>, Integer>();

	public void loadStudents() {
		students.add("Dylan");
		students.add("Kyle");
		// initialize student list w/ examples
	}

	public void addStudent(String studentID) {
		if (students.contains(studentID)) {
			System.out.println(studentID + " Is already in the system");
		} else {
			students.add(studentID);
		}
		// method called to add new students to students list
	}

	public void modStudent(String studentID, String newID) {
		students.remove(studentID);
		students.add(newID);
		// allows modification of studentID
	}

	public void delStudent(String studentID) {
		students.remove(studentID);
		// remove a student from the list
	}

	// look deeper
	public void createAssignment(String studentID, String assignmentName) {
		if (students.contains(studentID))
			assignment.put(studentID, assignmentName);
	}

	// adds new assignment to each student in assignment map
	public void modAssignment(String assignmentName, String newAssignmentName) {
		for (String x : students) {
			assignment.replace(x, assignmentName, newAssignmentName);
			// allows assignments in assignment map to be modified and does so
			// for each student
		}
	}

	public void delAssignment(String assignmentName) {
		for (String x : students) {
			assignment.remove(x, assignmentName);
			// remove specified assignment from assignment map
		}
	}

	public void list() {
		/*
		 * this method was mostly for display students button
		 */
		for (String x : students) {
			System.out.println(x);
			// return x;
		}
		// return stu;
	}

	public void grade(String student, String hw, int grade) {
		for(String x : students){
			Map<String, String> m = new HashMap<String, String>();
		grades.put(m, grade);
		}
		// this method will input a grade for the specified assignment of the
		// specified student
	}

	public void showGrade(String student, String hw) {
		for (String x : students) {
			if (student.equals(x)) {
				System.out.println(grades.get(assignment));
			}
		}
	}

	public static void main(String[] arg) {
		StudentDB db = new StudentDB();
		db.loadStudents();
		db.addStudent("Nova");
		db.list();
		db.createAssignment("Kyle", "First assignment");
		System.out.println(db.assignment.values());
		db.createAssignment("Kyle", "First");
		System.out.println(db.assignment.get("Kyle"));
		db.grade("Kyle", "First assignment", 100);
		db.showGrade("Kyle", "First assignment");
		db.modStudent("Kyle", "K");
		System.out.println(db.assignment.keySet());
		//db.list();
	}
}
