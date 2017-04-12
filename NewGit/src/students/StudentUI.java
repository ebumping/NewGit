package students;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class StudentUI extends StudentDatabase{

	private JFrame frame;
	private JTextField Student;
	private JTextField Assignment;
	private JTextField Grade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUI window = new StudentUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentUI() {
		initialize();
		loadStudents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Student = new JTextField();
		Student.setBounds(338, 11, 86, 20);
		frame.getContentPane().add(Student);
		Student.setColumns(10);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(282, 14, 46, 14);
		frame.getContentPane().add(lblStudent);
		
		Assignment = new JTextField();
		Assignment.setBounds(338, 42, 86, 20);
		frame.getContentPane().add(Assignment);
		Assignment.setColumns(10);
		
		JLabel lblAssignment = new JLabel("Assignment");
		lblAssignment.setBounds(263, 45, 65, 14);
		frame.getContentPane().add(lblAssignment);
		
		Grade = new JTextField();
		Grade.setBounds(338, 73, 86, 20);
		frame.getContentPane().add(Grade);
		Grade.setColumns(10);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(282, 76, 37, 14);
		frame.getContentPane().add(lblGrade);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Students x = new Students(Student.getText(), Assignment.getText(), grade);
				try {
					addStudent(x);
				}catch(Exception e1){
					e1.printStackTrace();
					
				}
			}
		});
		btnEnter.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(335, 193, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnDisplayStudents = new JButton("Display Students");
		btnDisplayStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list();
			}
		});
		btnDisplayStudents.setBounds(10, 227, 120, 23);
		frame.getContentPane().add(btnDisplayStudents);
	}
}
