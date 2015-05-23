import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class PlayGame extends JPanel {
	private JButton start = new JButton("Start");
	private boolean isStart = false;// Judge if the game start
	private boolean right = false;
	private JLabel question = new JLabel();
	private JLabel Remaintime;
	private JButton[] choice = new JButton[4]; //Four choice button
	private JButton next; 
	private int score = 0; 
	private int count = 1; //the number of doing question
	private int remainingTime = 20; // Initial time
	private boolean isAnswer; // Judge if a question is answered
	private boolean finish; // Judge if a question is last 
	private boolean[] isAppear = new boolean[10];// Avoid setting the repeated question. 
	private Timer timer; ///Use to control the remaining time and show over time message

	PlayGame(){
		setLayout(null);
		setBounds(0, 0, 688, 750);
		setOpaque(false); //Set transparent panel to appear the background of the Knowledge JFrame.
		setVisible(true);
		readyPlay();
		
	}
	//Not yet start game
	private void readyPlay(){ 
		
		start.setBounds(500,600,120,60);
		start.setFont(new Font("Microsoft YaHei",Font.BOLD,17));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStart = true;
				SetQuestion();
				repaint();
			}			
		});
		add(start);
		
		Remaintime = new JLabel();
		Remaintime.setBounds(440,0,250,80);
		Remaintime.setFont(new Font("Microsoft YaHei",Font.BOLD,17));
		timer = new Timer(1000, new ActionListener(){  //1000ms
			public void actionPerformed(ActionEvent e) {
				if(remainingTime == 0){
					JOptionPane.showMessageDialog(null, "Overtime! The answer is " + QuestionBase.C[QuestionBase.KEY]);
					
					count++;
					
					timer.stop();
					removeAll();
					repaint();
					
					if(count <= 10) // Over time. Set next question
						SetQuestion();
					
					remainingTime = 20;
				}
					
				Remaintime.setText("remaining time: " + remainingTime + " seconds");
				remainingTime--;
			}
	    });
	}
	
	//Set new question
	private void SetQuestion(){
		int randomQ = (int)(Math.random()*10); // The 10 is the number of questions of my QuestionBase.
		
		
		while(isAppear[randomQ] && count<=10){ // Avoid setting the repeated question. 
			randomQ = (int)(Math.random()*10);
		}
		
		isAppear[randomQ] = true;
		QuestionBase.question(randomQ);
		question = new JLabel("<html>"+QuestionBase.Q+"</html>", JLabel.CENTER);
		question.setForeground(Color.getHSBColor(10.3f, 13.2f, 42.4f)); // Set color
		question.setFont(new Font("Microsoft YaHei",Font.BOLD,QuestionBase.Q.length()<15?40:25));
		question.setBounds(120,60,400,100);
		add(question);
		for(int i=0; i<4; i++){
			choice[i] = new JButton(QuestionBase.C[i]);
			choice[i].setFont(new Font("Microsoft YaHei",Font.BOLD, QuestionBase.C[i].length()<10?35:25));
			choice[i].setBounds(130, 170 + 70*i, 400, 50);
			add(choice[i]);	
			RightJudge(i);
		}
		
		next = new JButton(count == 10? "Finish": "Next question");
		next.setFont(new Font("Microsoft YaHei",Font.BOLD,15));
		next.setBounds(450, 650, 200, 50);
		add(next);
		
		add(Remaintime);
		
		timer.start(); // start timer
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(isAnswer){
					timer.stop();
					remainingTime = 20; // reset remaining time
					count++;
					finish = (count > 10);
					if(right) // The answer is right
						score += 10;
					else
						JOptionPane.showMessageDialog(null, "Your answer is not correct! The answer is " + QuestionBase.C[QuestionBase.KEY]);
		
					isAnswer = false;
					right = false;
			
					removeAll();
					repaint();   
					if(!finish)
						SetQuestion(); // Set next question 
					else
						timer.stop();// If finishing the game, stop the Timer.
				
				}
				else // The user hasn't answered the question
					JOptionPane.showMessageDialog(null, "Please choose!");
				
				
				
			}
		});
	}
	
	//The action of the choice buttons
	private void RightJudge(int c){
		
		choice[c].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				isAnswer = true;
				if(QuestionBase.KEY == c){  //The answer is right
					right = true;
				}
				else
					right = false;
				
			}
	    });
		
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		
		if(isStart){
			
			if(count <= 10){  //Draw the current number of Question,choice,and score
				remove(start);
				g.setColor(Color.black);
				g.setFont(new Font("Microsoft YaHei",Font.BOLD,35));
				g.drawString("A.", 80, 210);
				g.drawString("B.", 80, 280);
				g.drawString("C.", 80, 350);
				g.drawString("D.", 80, 420);
				g.setFont(new Font("Microsoft YaHei",Font.BOLD,20));
				g.drawString("Question "+count+"/10", 10, 30);
				g.setColor(Color.yellow);
				g.drawString("Score: " + score, 20, 675);
				
			}
			else{   //Finish the questions and print the total score
				g.setColor(Color.black);
				g.setFont(new Font("Microsoft YaHei",Font.BOLD,35));
				g.drawString("Your score:" + score, 230, 310);
				
				JButton exit = new JButton("Exit");
				exit.setFont(new Font("Microsoft YaHei",Font.BOLD,30));
				exit.setBounds(250, 420, 200, 50);
				exit.setContentAreaFilled(false); //Set transparent button
				add(exit);
				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Knowledge.getFrame().dispose(); // close Knowledge JFrame(main window)
					}
				});
			}
			
		}
		else{
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Welcome",Font.BOLD,30));
			g.drawString("Welcome", 280, 75);
		
			g.setColor(Color.getHSBColor(10.3f, 53.2f, 42.4f));
			g.setFont(new Font(SignFrame.getID_And_Name(),Font.BOLD,24));
			g.drawString(SignFrame.getID_And_Name(), 240, 150); //Print the signer's data
		}
	}
	
	public static void Music(){ 
		try{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(PlayGame.class.getResource("music/ed.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start( ); //Broadcast the music
			
		}catch(Exception ex){}
		}
	
	
}
