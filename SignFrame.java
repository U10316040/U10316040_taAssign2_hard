
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class SignFrame extends JFrame {
	private static JLabel name = new JLabel("Name ");
	private static JLabel StudentID = new JLabel("Student ID ");
	private static JTextField InputN = new JTextField();
	private static JTextField InputID = new JTextField();
	private static JButton Sign = new JButton("OK");
	
	SignFrame(){
		
		setTitle("Sign");
		setBounds(130, 130, 300, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		name.setBounds(30,40,80,20);
		add(name);
		
		InputN.setBounds(95,40,120,20);
		InputN.setColumns(10);
		add(InputN);
		
		StudentID.setBounds(28,80,80,20);
		add(StudentID);
		
		InputID.setBounds(95,80,120,20);
		InputID.setColumns(9);
		add(InputID);
		
		Sign.setBounds(180, 120, 60, 20);
		Sign.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(!InputID.getText().isEmpty() && !InputN.getText().isEmpty()){ //Judge if the ID or the name is empty. 
					Knowledge.getFrame().setVisible(true); // show the main Window
					Knowledge.getFrame().setTitle("U10316040_question");
					dispose(); // Write SwingUtilities.windowForComponent(Sign).dispose() can also close the SignFrame;
					Knowledge.getGamePanel().Music();//start music
				}
				else
					JOptionPane.showMessageDialog(null, "Error ID or Name");
				
			}
		});
		add(Sign);
	}
	
	// Get ID and name
	public static String getID_And_Name(){
		return InputID.getText() + " " + InputN.getText();
	}
	
}
