package Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;

public class EnterName extends JFrame implements ActionListener{
	
	Border blackLine ;
	JButton start, rules;
	JTextField fullName;
	
	EnterName(){
		
		setLayout(null);
		blackLine = BorderFactory.createLineBorder(Color.BLACK, 2);
		
	//	Icon Jframe
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("image/icon.png"));
		setIconImage(icon.getImage());
		
		setTitle("Quiz Time");
		setVisible(true);
		setLocation(100,80);
		setSize(1000, 500);
		getContentPane().setBackground(Color.WHITE);
		
	//  Name Label
		
		JLabel name = new JLabel("Enter Full Name ");
		name.setFont(new Font("Loharam", Font.BOLD, 20));
		name.setBounds(300 ,200, 180, 30);
		add(name);
		
	//	Name Text Field
		
		fullName = new JTextField();
		fullName.setBorder(blackLine);
		fullName.setFont(new Font("Raleway", Font.PLAIN, 14));
		fullName.setBounds(490, 200, 200, 30);
		add(fullName);
		
	//	Start the Quiz
		
		start = new JButton("Start");
		start.setBackground(Color.BLACK);
		start.setForeground(Color.WHITE);
		start.setBounds(550, 300, 100, 30);
		start.addActionListener(this);
		add(start);
		
	//	Back to Rules
		
		rules = new JButton("Rules");
		rules.setBackground(Color.BLACK);
		rules.setForeground(Color.WHITE);
		rules.setBounds(330, 300, 100, 30);
		rules.addActionListener(this);
		add(rules);
		
	}
	
	// Action performed on Button
	
		  public void actionPerformed(ActionEvent e) {
			  if(e.getSource() == rules ) {
				  
				  setVisible(false);
				  new Login_Quiz();
				  
			  }else {
				 	  
				  String name = fullName.getText();
				  setVisible(false);
				  new Quiz(name);
				  
			  }
		  }
	public static void main(String[] argds) {
		
		new EnterName();
	}
}
