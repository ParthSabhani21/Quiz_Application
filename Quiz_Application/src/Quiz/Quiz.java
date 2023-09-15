package Quiz;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

	Border blackLine;
	JRadioButton opt1, opt2, opt3, opt4;
	JButton next, submit, previous;
	JLabel qno, question;
	ButtonGroup groupoptions;

	String questions[][] = new String[10][5];
	String answers[][] = new String[10][2];
	String useranswers[][] = new String[10][1];

	public static int timer = 30;
	public static int ans_given = 0;
	public static int count = 0;
	public static int score = 0;

	String name;

	Quiz(String name) {

		this.name = name;

		setLayout(null);
		blackLine = BorderFactory.createLineBorder(Color.BLACK, 2);

		// Icon Jframe

		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("image/icon.png"));
		setIconImage(icon.getImage());

		setTitle("Quiz Time");
		setVisible(true);
		setBounds(50, 20, 1200, 650);
		getContentPane().setBackground(Color.WHITE);

		// Image Quiz

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/quiz.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1200, 200);
		add(image);

		// Question Number

		qno = new JLabel();
		qno.setFont(new Font("Tohoma", Font.PLAIN, 20));
		qno.setBounds(50, 300, 50, 30);
		add(qno);

		// Question

		question = new JLabel();
		question.setFont(new Font("Tohoma", Font.PLAIN, 20));
		question.setBounds(90, 300, 800, 30);
		add(question);

		// Questions

		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
		questions[0][1] = "JVM";
		questions[0][2] = "JDB";
		questions[0][3] = "JDK";
		questions[0][4] = "JRE";

		questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
		questions[1][1] = "int";
		questions[1][2] = "Object";
		questions[1][3] = "long";
		questions[1][4] = "void";

		questions[2][0] = "Which package contains the Random class?";
		questions[2][1] = "java.util package";
		questions[2][2] = "java.lang package";
		questions[2][3] = "java.awt package";
		questions[2][4] = "java.io package";

		questions[3][0] = "An interface with no fields or methods is known as?";
		questions[3][1] = "Runnable Interface";
		questions[3][2] = "Abstract Interface";
		questions[3][3] = "Marker Interface";
		questions[3][4] = "CharSequence Interface";

		questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
		questions[4][1] = "Stack";
		questions[4][2] = "String memory";
		questions[4][3] = "Random storage space";
		questions[4][4] = "Heap memory";

		questions[5][0] = "Which of the following is a marker interface?";
		questions[5][1] = "Runnable interface";
		questions[5][2] = "Remote interface";
		questions[5][3] = "Readable interface";
		questions[5][4] = "Result interface";

		questions[6][0] = "Which keyword is used for accessing the features of a package?";
		questions[6][1] = "import";
		questions[6][2] = "package";
		questions[6][3] = "extends";
		questions[6][4] = "export";

		questions[7][0] = "In java, jar stands for?";
		questions[7][1] = "Java Archive Runner";
		questions[7][2] = "Java Archive";
		questions[7][3] = "Java Application Resource";
		questions[7][4] = "Java Application Runner";

		questions[8][0] = "Which of the following is a mutable class in java?";
		questions[8][1] = "java.lang.StringBuilder";
		questions[8][2] = "java.lang.Short";
		questions[8][3] = "java.lang.Byte";
		questions[8][4] = "java.lang.String";

		questions[9][0] = "Which of the following option leads to the portability and security of Java?";
		questions[9][1] = "Bytecode is executed by JVM";
		questions[9][2] = "The applet makes the Java code secure and portable";
		questions[9][3] = "Use of exception handling";
		questions[9][4] = "Dynamic binding between objects";

		// Answers

		answers[0][1] = "JDB";
		answers[1][1] = "int";
		answers[2][1] = "java.util package";
		answers[3][1] = "Marker Interface";
		answers[4][1] = "Heap memory";
		answers[5][1] = "Remote interface";
		answers[6][1] = "import";
		answers[7][1] = "Java Archive";
		answers[8][1] = "java.lang.StringBuilder";
		answers[9][1] = "Bytecode is executed by JVM";

		// Option Radio Button

		opt1 = new JRadioButton();
		opt1.setBounds(180, 360, 400, 30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt1);

		opt2 = new JRadioButton();
		opt2.setBounds(180, 410, 400, 30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt2);

		opt3 = new JRadioButton();
		opt3.setBounds(180, 460, 400, 30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt3);

		opt4 = new JRadioButton();
		opt4.setBounds(180, 510, 400, 30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt4);

		// Group Option Radio Button

		groupoptions = new ButtonGroup();
		groupoptions.add(opt1);
		groupoptions.add(opt2);
		groupoptions.add(opt3);
		groupoptions.add(opt4);
		
		// Previous Button

		previous = new JButton("Previous");
		previous.setBackground(Color.BLACK);
		previous.setForeground(Color.WHITE);
		previous.setBounds(680, 500, 100, 50);
		previous.addActionListener(this);
		previous.setEnabled(false);
		add(previous);

		// Next Button

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(800, 500, 100, 50);
		next.addActionListener(this);
		add(next);

		// Submit Button

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(920, 500, 100, 50);
		submit.addActionListener(this);
		submit.setEnabled(false);
		add(submit);

		start(count);

	}

	// Button Action
	
	   public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource() == next) {
	            
	        	repaint();
	            ans_given = 1;
	            
	            if (groupoptions.getSelection() == null) {
	               useranswers[count][0] = "";
	            } else {
	                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
	            }
	            
	            if (count == 8) {
	                next.setEnabled(false);
	                submit.setEnabled(true);
	            }
	            
	            count++;
	            start(count);
	            
	        } else if (ae.getSource() == previous) {
	        	
	        	repaint();
	        	ans_given = 1;
		            if (groupoptions.getSelection() == null) {
		                useranswers[count][0] = "";
		            } else {
		                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
		            }
		            if(count == 2) {
		         
		            	previous.setEnabled(true);
	        	}
		            count -- ;
		            start(count);
	        	
	        }else if (ae.getSource() == submit) {
	            ans_given = 1;
	            if (groupoptions.getSelection() == null) {
	                useranswers[count][0] = "";
	            } else {
	                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
	            }
	            
	            for (int i = 0; i < useranswers.length; i++) {
	                if (useranswers[i][0].equals(answers[i][1])) {
	                    score += 1;
	                } else {
	                    score += 0;
	                }
	            }
	            setVisible(false);
	            new Score(name, score);
	        }
	    }
	    
	 // Timer
	   
	    public void paint(Graphics g) {
	        super.paint(g);
	        
	        String time = "Time left - " + timer + " seconds"; // 30
	        g.setColor(Color.RED);
	        g.setFont(new Font("Tahoma", Font.BOLD, 20));
	        
	        if (timer > 0) { 
	            g.drawString(time, 740, 450);
	        } else {
	            g.drawString("Times up!!", 740, 450);
	        }
	        
	        timer--; // 29
	        
	        try {
	            Thread.sleep(1000);
	            repaint();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        if (ans_given == 1) {
	            ans_given = 0;
	            timer = 30;
	        } else if (timer < 0) {
	            timer = 30;
	            
	            if (count == 8) {
	                next.setEnabled(false);
	             //   previous.setEnabled(true);                
	                submit.setEnabled(true);
	            }
	            if (count == 9) { // submit button
	                if (groupoptions.getSelection() == null) {
	                   useranswers[count][0] = "";
	                } else {
	                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
	                }
	                
	                for (int i = 0; i < useranswers.length; i++) {
	                    if (useranswers[i][0].equals(answers[i][1])) {
	                        score += 1;
	                    } else {
	                        score += 0;
	                    }
	                }
	                setVisible(false);
	                new Score(name, score);
	            } else{ // next button
	                if (groupoptions.getSelection() == null) {
	                   useranswers[count][0] = "";
	                } else {
	                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
	                }
	                count++; // 0 // 1
	                start(count);
	            }
	        }
	        
	    }
	 

	// Start Count

	public void start(int count) {
		qno.setText("" + (count + 1) + ". ");
		question.setText(questions[count][0]);
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);

		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);

		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);

		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);

		groupoptions.clearSelection();
	}

	public static void main(String[] args) {

		new Quiz("User");
	}
}
