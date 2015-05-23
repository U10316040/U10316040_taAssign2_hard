
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Knowledge extends JFrame {
	private static Knowledge frame;
	private static SignFrame signframe;
	private static PlayGame gamePanel;
	
	public Knowledge(){
		add(gamePanel);
		super.setResizable(false); //Avoiding user enlarging  the frame
		setBackGround();
	}
	
	public static void main(String[] args) {
		signframe = new SignFrame();
		gamePanel = new PlayGame();
		frame = new Knowledge();
		frame.setBounds(100, 0, 688, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // not setting layout
		frame.setVisible(false);
	}
	
	// Get frame
	public static Knowledge getFrame(){
		return frame;
	}
	
	//get gamePanel
	public static PlayGame getGamePanel(){
		return gamePanel;
	}
	
	// Set background
	public void setBackGround(){
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Image/background.jpg"));
		image =  image.getScaledInstance(688, 750, Image.SCALE_DEFAULT);
		JLabel picture = new JLabel(new ImageIcon(image));
		picture.setBounds(0, 0, 688, 750);
		add(picture);
	}
}
