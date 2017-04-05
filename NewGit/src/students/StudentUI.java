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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(338, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setBounds(282, 14, 46, 14);
		frame.getContentPane().add(lblStudent);
		
		textField_1 = new JTextField();
		textField_1.setBounds(338, 42, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAssignment = new JLabel("Assignment");
		lblAssignment.setBounds(263, 45, 65, 14);
		frame.getContentPane().add(lblAssignment);
		
		textField_2 = new JTextField();
		textField_2.setBounds(338, 73, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(282, 76, 37, 14);
		frame.getContentPane().add(lblGrade);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnDisplayStudents.setBounds(10, 227, 120, 23);
		frame.getContentPane().add(btnDisplayStudents);
	}
}
