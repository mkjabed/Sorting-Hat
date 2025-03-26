package com.housequiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SortingHatQuiz{
	static int G=0, R=0, H=0, S=0, Check=0;
	
	public static void main(String[] args) {

		
		
	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(800, 800);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(null);
	        frame.setTitle("Sorting Hat");
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 247, 227)); 
	        panel.setBounds(0, 0, 800, 800); 
	        panel.setLayout(null); 

	        
	        JLabel q1 = new JLabel("1. Dawn or Dusk?");
	        q1.setFont(new Font("Arial", Font.BOLD, 20));
	        q1.setBounds(5, 10, 200, 30);
	        panel.add(q1);

	        JRadioButton q1option1 = new JRadioButton("Dawn");
	        q1option1.setFont(new Font("Arial", Font.BOLD, 20));
	        q1option1.setBounds(5, 50, 200, 30);
	        q1option1.setBackground(panel.getBackground());  
	        q1option1.setOpaque(true);
	        panel.add(q1option1);

	        JRadioButton q1option2 = new JRadioButton("Dusk");
	        q1option2.setFont(new Font("Arial", Font.BOLD, 20));
	        q1option2.setBounds(5, 80, 200, 30);
	        q1option2.setBackground(panel.getBackground());  
	        q1option2.setOpaque(true);
	        panel.add(q1option2);
	     

	        ButtonGroup group1 = new ButtonGroup();
	        group1.add(q1option1);
	        group1.add(q1option2);
	        
	        JLabel q2 = new JLabel("2. Forest or River?");
	        q2.setFont(new Font("Arial", Font.BOLD, 20));
	        q2.setBounds(5, 120, 200, 30);
	        q2.setBackground(panel.getBackground());  
	        q2.setOpaque(true);
	        panel.add(q2);

	        JRadioButton q2option1 = new JRadioButton("Forest");
	        q2option1.setFont(new Font("Arial", Font.BOLD, 20));
	        q2option1.setBounds(5, 160, 200, 30);
	        q2option1.setBackground(panel.getBackground());  
	        q2option1.setOpaque(true);
	        panel.add(q2option1);

	        JRadioButton q2option2 = new JRadioButton("River");
	        q2option2.setFont(new Font("Arial", Font.BOLD, 20));
	        q2option2.setBounds(5, 190, 200, 30);
	        q2option2.setBackground(panel.getBackground());  
	        q2option2.setOpaque(true);
	        panel.add(q2option2);

	        ButtonGroup group2 = new ButtonGroup();
	        group2.add(q2option1);
	        group2.add(q2option2);
	        
	        JLabel q3 = new JLabel("3. Moon or Stars?");
	        q3.setFont(new Font("Arial", Font.BOLD, 20));
	        q3.setBounds(5, 230, 200, 30);
	        q3.setBackground(panel.getBackground());  
	        q3.setOpaque(true);
	        panel.add(q3);

	        JRadioButton q3option1 = new JRadioButton("Moon");
	        q3option1.setFont(new Font("Arial", Font.BOLD, 20));
	        q3option1.setBounds(5, 270, 200, 30);
	        q3option1.setBackground(panel.getBackground());  
	        q3option1.setOpaque(true);
	        panel.add(q3option1);

	        JRadioButton q3option2 = new JRadioButton("Stars");
	        q3option2.setFont(new Font("Arial", Font.BOLD, 20));
	        q3option2.setBounds(5, 300, 200, 30);
	        q3option2.setBackground(panel.getBackground());  
	        q3option2.setOpaque(true);
	        panel.add(q3option2);

	        ButtonGroup group3 = new ButtonGroup();
	        group3.add(q3option1);
	        group3.add(q3option2);
	        
	        JLabel q4 = new JLabel("4. Which of the following would you most hate people to call you?");
	        q4.setFont(new Font("Arial", Font.BOLD, 20));
	        q4.setBounds(5, 340, 800, 30);
	        q4.setBackground(panel.getBackground());  
	        q4.setOpaque(true);
	        panel.add(q4);

	        JRadioButton q4option1 = new JRadioButton("Ordinary");
	        q4option1.setFont(new Font("Arial", Font.BOLD, 20));
	        q4option1.setBounds(5, 370, 200, 30);
	        q4option1.setBackground(panel.getBackground());  
	        q4option1.setOpaque(true);
	        panel.add(q4option1);

	        JRadioButton q4option2 = new JRadioButton("Ignorant");
	        q4option2.setFont(new Font("Arial", Font.BOLD, 20));
	        q4option2.setBounds(5, 400, 200, 30);
	        q4option2.setBackground(panel.getBackground());  
	        q4option2.setOpaque(true);
	        panel.add(q4option2);

	        JRadioButton q4option3 = new JRadioButton("Cowardly");
	        q4option3.setFont(new Font("Arial", Font.BOLD, 20));
	        q4option3.setBounds(5, 430, 200, 30);
	        q4option3.setBackground(panel.getBackground());  
	        q4option3.setOpaque(true);
	        panel.add(q4option3);

	        JRadioButton q4option4 = new JRadioButton("Selfish");
	        q4option4.setFont(new Font("Arial", Font.BOLD, 20));
	        q4option4.setBounds(5, 460, 200, 30);
	        q4option4.setBackground(panel.getBackground());  
	        q4option4.setOpaque(true);
	        panel.add(q4option4);
	        
	        ButtonGroup group4 = new ButtonGroup();
	        group4.add(q4option1);
	        group4.add(q4option2);
	        group4.add(q4option3);
	        group4.add(q4option4);
	        
	        JLabel q5 = new JLabel("5. How would you like to be known to history?");
	        q5.setFont(new Font("Arial", Font.BOLD, 20));
	        q5.setBounds(5, 500, 800, 30); 
	        q5.setBackground(panel.getBackground());  
	        q5.setOpaque(true);
	        panel.add(q5);

	        JRadioButton q5option1 = new JRadioButton("The Wise");
	        q5option1.setFont(new Font("Arial", Font.BOLD, 20));
	        q5option1.setBounds(5, 540, 300, 30);  
	        q5option1.setBackground(panel.getBackground());  
	        q5option1.setOpaque(true);
	        panel.add(q5option1);

	        JRadioButton q5option2 = new JRadioButton("The Good");
	        q5option2.setFont(new Font("Arial", Font.BOLD, 20));
	        q5option2.setBounds(5, 570, 300, 30);  
	        q5option2.setBackground(panel.getBackground());  
	        q5option2.setOpaque(true);
	        panel.add(q5option2);

	        JRadioButton q5option3 = new JRadioButton("The Great");
	        q5option3.setFont(new Font("Arial", Font.BOLD, 20));
	        q5option3.setBounds(5, 600, 300, 30);  
	        q5option3.setBackground(panel.getBackground());  
	        q5option3.setOpaque(true);
	        panel.add(q5option3);

	        JRadioButton q5option4 = new JRadioButton("The Bold");
	        q5option4.setFont(new Font("Arial", Font.BOLD, 20));
	        q5option4.setBounds(5, 630, 200, 30);  
	        q5option4.setBackground(panel.getBackground());  
	        q5option4.setOpaque(true);
	        panel.add(q5option4);

	        ButtonGroup group5 = new ButtonGroup();
	        group5.add(q5option1);
	        group5.add(q5option2);
	        group5.add(q5option3);
	        group5.add(q5option4);

	        
	        JButton Submit = new JButton("Check");
	        Submit.setFont(new Font("Arial", Font.PLAIN, 18));
	        Submit.setBounds(250, 700, 100, 30);
	        panel.add(Submit);
	        
	        Submit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (q1option1.isSelected()) {
	                    G += 1; R += 1; Check+=1;
	                }
	                if (q1option2.isSelected()) {
	                    H += 1; S += 1; Check+=1;
	                }
	                if (q2option1.isSelected()) {
	                    G += 1; R += 1; Check+=1;
	                }
	                if (q2option2.isSelected()) {
	                    H += 1; S += 1; Check+=1;
	                }
	                if (q3option1.isSelected()) {
	                    R += 1; S += 1; Check+=1;
	                }
	                if (q3option2.isSelected()) {
	                    G += 1; H += 1; Check+=1;
	                }
	                if (q4option1.isSelected()) {
	                    S += 1; Check+=1 ;
	                }
	                if (q4option2.isSelected()) {
	                    R += 1; Check+=1 ;
	                }
	                if (q4option3.isSelected()) {
	                    G += 1; Check+=1 ;
	                }
	                if (q4option4.isSelected()) {
	                    H += 1; Check+=1 ;
	                }
	                
	                if (q5option1.isSelected()) {
	                    R += 1; Check+=1 ;
	                }
	                if (q5option2.isSelected()) {
	                    H += 1; Check+=1 ;
	                }
	                if (q5option3.isSelected()) {
	                    S += 1; Check+=1 ;
	                }
	                if (q5option4.isSelected()) {
	                    G += 1; Check+=1 ;
	                }
	                
	                int max = Math.max(Math.max(G, R), Math.max(H, S));
	                
	                if (Check<5) {
	                    JOptionPane.showMessageDialog(frame, 
	                        "Oops! The Sorting Hat is feeling a bit confused... \nYou must answer all the questions before it can sort you. ⚡",
	                        "Confused :(", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(frame, 
	                        max == G ? "You Are Gryffindor 🦁\nBrave, daring, and full of heart. You face challenges head-on and never back down!" :
	                        max == R ? "You Are Ravenclaw 🦅\nSmart, creative, and always seeking knowledge. Your mind is your greatest strength." :
	                        max == H ? "You Are Hufflepuff 🦡\nLoyal, kind, and hardworking. You value fairness and always support your friends." :
	                                   "You Are Slytherin 🐍\nCunning, ambitious, and resourceful. You know how to get what you want and make things happen!",
	                        	"Sorted!!!",JOptionPane.INFORMATION_MESSAGE);
	                }



	            }
	        });

	        JButton resetButton = new JButton("Reset");
	        resetButton.setFont(new Font("Arial", Font.PLAIN, 18));
	        resetButton.setBounds(450, 700, 100, 30);
	        panel.add(resetButton);

	        resetButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                group1.clearSelection();
	                group2.clearSelection();
	                group3.clearSelection();
	                group4.clearSelection();
	                group5.clearSelection();
	                Check = G = R = H = S = 0;
	            }
	        });

	        


	        frame.setContentPane(panel); 
	        frame.setVisible(true);
	}
	
}
