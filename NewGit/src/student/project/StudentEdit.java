package student.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentEdit extends StudentDB{

	private JFrame frame;
	private JTextField txtFind;
	private JTextField txtReplace;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEdit window = new StudentEdit();
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
	public StudentEdit() {
		initialize();
	}
	public void callEdit(){
		//makes it so I don't have to call StudentEdit main method
		EventQueue.invokeLater(new Runnable(){
		public void run(){
			try {
				StudentEdit window = new StudentEdit();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtFind = new JTextField();
		txtFind.setBounds(338, 11, 86, 20);
		frame.getContentPane().add(txtFind);
		txtFind.setColumns(10);
		
		txtReplace = new JTextField();
		txtReplace.setBounds(338, 42, 86, 20);
		frame.getContentPane().add(txtReplace);
		txtReplace.setColumns(10);
		
		JLabel lblFind = new JLabel("Find");
		lblFind.setBounds(282, 14, 46, 14);
		frame.getContentPane().add(lblFind);
		
		JLabel lblReplaceW = new JLabel("Replace w/");
		lblReplaceW.setBounds(282, 45, 59, 14);
		frame.getContentPane().add(lblReplaceW);
		
		JButton btnEnter = new JButton("Modify Assignment");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					modAssignment(txtFind.getText(), txtReplace.getText());
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnEnter.setBounds(259, 228, 165, 23);
		frame.getContentPane().add(btnEnter);
		
		btnNewButton = new JButton("Modify Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					for(String x : students){
					modStudent(txtFind.getText(), txtReplace.getText());
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(259, 194, 165, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 194, 130, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Assignment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 228, 130, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblEnterTheStudent = new JLabel("<html>" + 
		"Enter the student or \rassinment you wish to \ndelete in the 'Find' Field" + "</html>");
		//Use HTML in the JLabel in order to wrap text.
		lblEnterTheStudent.setBounds(10, 107, 130, 76);
		frame.getContentPane().add(lblEnterTheStudent);
	}
}
