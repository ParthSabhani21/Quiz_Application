package Quiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
	
	String name;
	JButton pa;
//int count = 0;

    Score(String name, int score) {
    	
    	this.name = name;
    	
    	// Icon Jframe
    	
    	setLayout(null);
    	ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("image/icon.png"));
    	setIconImage(icon.getImage());

    	setTitle("Quiz Time");
    	setVisible(true);
    	setBounds(100, 40, 1000, 650);
    	getContentPane().setBackground(Color.WHITE);
        
    //  Image
    	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/result.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);
        
        JLabel heading = new JLabel("Thank You " + name + " For Playing.");
        heading.setBounds(450, 200, 500, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
     // Display Score 
        
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(500, 300, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        
     //	Submit Button  
        
        pa = new JButton("Play Again");
		pa.setBackground(Color.BLACK);
		pa.setForeground(Color.WHITE);
		pa.setBounds(520, 400, 120, 50);
		pa.addActionListener(this);
		add(pa);
        
        setVisible(true);
    }
    
    //  Button Action
    
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource() == pa) {
        setVisible(false);
        new Login_Quiz();
        Quiz.count = 0;
        Quiz.score = 0;
    	}
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
