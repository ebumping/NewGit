package student.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentUI extends StudentDB {

	private JFrame frame;
	private JTextField txtStudent;
	private JTextField txtAssignment;
	private JTextField txtGrade;
	private JButton btnDisplayStudents;
	private JButton btnDisplayGrade;
	private JButton btnAddStudent;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField replace;
	private JLabel lblNewLabel;

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

		txtStudent = new JTextField();
		txtStudent.setBounds(338, 11, 86, 20);
		frame.getContentPane().add(txtStudent);
		txtStudent.setColumns(10);

		txtAssignment = new JTextField();
		txtAssignment.setBounds(338, 42, 86, 20);
		frame.getContentPane().add(txtAssignment);
		txtAssignment.setColumns(10);

		txtGrade = new JTextField();
		txtGrade.setBounds(338, 73, 86, 20);
		frame.getContentPane().add(txtGrade);
		txtGrade.setColumns(10);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(282, 14, 46, 14);
		frame.getContentPane().add(lblStudent);

		JLabel lblAssignment = new JLabel("Assignment");
		lblAssignment.setBounds(267, 45, 61, 14);
		frame.getContentPane().add(lblAssignment);

		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(293, 76, 35, 14);
		frame.getContentPane().add(lblGrade);

		JButton btnEdit = new JButton("Enter Grade");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					grade(txtStudent.getText(), txtAssignment.getText(), Integer.parseInt(txtGrade.getText()));
				} catch (NumberFormatException e1) {
					// in the case that the value in grade field is not an
					// integer this exception is thrown
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setBounds(288, 228, 136, 23);
		frame.getContentPane().add(btnEdit);

		btnDisplayStudents = new JButton("Display Students");
		btnDisplayStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list();
			}
		});
		btnDisplayStudents.setBounds(10, 228, 126, 23);
		frame.getContentPane().add(btnDisplayStudents);

		JButton btnEdit_1 = new JButton("Edit Student");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//StudentEdit se = new StudentEdit();
				try {				
						modStudent(txtStudent.getText(), replace.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEdit_1.setBounds(288, 160, 136, 23);
		frame.getContentPane().add(btnEdit_1);

		btnDisplayGrade = new JButton("Display Grade");
		btnDisplayGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGrade(txtStudent.getText(), txtAssignment.getText());
			}
		});
		btnDisplayGrade.setBounds(10, 194, 126, 23);
		frame.getContentPane().add(btnDisplayGrade);

		btnAddStudent = new JButton("Create Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStudent.getText().isEmpty()){
					System.out.println("Student is a required field");
				}else{
				try {
					addStudent(txtStudent.getText());
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					}
				}
			}
		});
		btnAddStudent.setBounds(10, 10, 139, 23);
		frame.getContentPane().add(btnAddStudent);

		btnNewButton = new JButton("Create Assignment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAssignment.getText().isEmpty()){
					System.out.println("Assignment is a required field");
				}else{
				try {
					createAssignment(txtStudent.getText(), txtAssignment.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		btnNewButton.setBounds(10, 41, 139, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete Student");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					delStudent(txtStudent.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(159, 10, 105, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnDeleteHw = new JButton("Delete HW");
		btnDeleteHw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					delAssignment(txtAssignment.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnDeleteHw.setBounds(158, 41, 106, 23);
		frame.getContentPane().add(btnDeleteHw);
		
		btnNewButton_1 = new JButton("Edit Assignment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					modAssignment(txtAssignment.getText(), replace.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(288, 194, 136, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		replace = new JTextField();
		replace.setBounds(338, 104, 86, 20);
		frame.getContentPane().add(replace);
		replace.setColumns(10);
		
		JLabel lblReplaceW = new JLabel("Replace w/");
		lblReplaceW.setBounds(267, 107, 61, 14);
		frame.getContentPane().add(lblReplaceW);
		
		lblNewLabel = new JLabel("<html>" + 
				"Enter the student or \rassinment you wish to \nmodify "
				+ "and use the 'replace' field to specify the new ID or assignment" 
				+ "</html>");
				//Use HTML in the JLabel in order to wrap text.
		lblNewLabel.setBounds(165, 146, 113, 105);
		frame.getContentPane().add(lblNewLabel);
	}
}
