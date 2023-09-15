package Quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Login_Quiz extends JFrame implements ActionListener{
	
	JButton start;
	public String title;
	
	Login_Quiz(){
		
		
	//	Icon JFrame
		
		setLayout(null);
		ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("image/icon.png"));
		setIconImage(logo.getImage());
		
		setTitle(title);
		setLocation(100, 80);
		setSize(1000, 500);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
	//	Image Quiz
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/main.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 400, 500);
		add(image);
		
	//	Quiz Time
		
		JLabel quizTime = new JLabel("QUIZ  TIME");
		quizTime.setFont(new Font("Mangolain Baiti", Font.BOLD, 40));
		quizTime.setBounds(600, 20, 400, 50);
		add(quizTime);
		
	//	Rules Title
		
		JLabel rulesTitle = new JLabel("Rules :");
		rulesTitle.setFont(new Font("Raleway", Font.BOLD, 20));
		rulesTitle.setBounds(420, 90, 100, 20);
		add(rulesTitle);
		
	//  Rules
		
		JLabel rule =  new JLabel();
		rule.setFont(new Font("Tohoma", Font .PLAIN, 16));
		rule.setBounds(420, 0, 400, 500);
		rule.setText(
	            "<html>"+ 
	                "1. Answer the Question Point to Point." + "<br><br>" +
	                "2. All the questions are compulsory." + "<br><br>" +
	                "3. Don't Try to be Over Smart." + "<br><br>" +
	                "4. Good Luck For the Quiz." + "<br><br>" +
	                "4. Enjoy the Fun." + "<br><br>" +
	            "<html>"
	);
		add(rule);

	//	Start Button	
	
		start = new JButton("Start");
		start.setBackground(Color.BLACK);
		start.setForeground(Color.WHITE);
		start.setBounds(650, 400, 100, 30);
		start.addActionListener(this);
		add(start);
		
	}
	
	// Action performed on Button
	
	  public void actionPerformed(ActionEvent e) {
		  if(e.getSource() == start ) {
			  setVisible(false);
			  new EnterName();
		  }
	  }
	
	public static void main(String[] arg) {
		new Login_Quiz();
	}
}
