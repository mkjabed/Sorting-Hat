package com.housequiz;

import java.io.File;
import javax.sound.sampled.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {
    Image backgroundImage;
    Image logoImage;

    public BackgroundPanel(String bgPath, String logoPath) {
        backgroundImage = new ImageIcon(bgPath).getImage();
        ImageIcon logoIcon = new ImageIcon(logoPath);
        logoImage = logoIcon.getImage().getScaledInstance(220, 70, Image.SCALE_SMOOTH);
    }

    @Override
	protected void paintComponent(Graphics g) {
    	
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        
        int logoX = (getWidth() - 220) / 2;
        int logoY = 20;
        g.drawImage(logoImage, logoX, logoY, 220, 70, this); 
    }
}


public class SortingHatQuiz {
    static int G = 0, R = 0, H = 0, S = 0;
    static int currentQuestion = 0;

    static String[] questions = {
    	    "Which trait do you value the most?",
    	    "Which subject excites you the most?",
    	    "What would you do if you saw someone being bullied?",
    	    "Choose a magical pet:",
    	    "Pick a magical item:"
    	};

    	static String[][] answers = {
    	    {"Bravery", "Wisdom", "Loyalty", "Ambition"},
    	    {"Defense Against the Dark Arts", "Astronomy", "Herbology", "Potions"},
    	    {"Stand up to the bully", "Outsmart them calmly", "Comfort the victim", "Use it to your advantage"},
    	    {"Phoenix", "Owl", "Badger", "Snake"},
    	    {"Invisibility Cloak", "Time-Turner", "Marauder’s Map", "Elder Wand"}
    	};

    	static int[][] points = {
    	    {3, 2, 1, 4},  // Q1
    	    {3, 4, 2, 1},  // Q2
    	    {4, 2, 3, 1},  // Q3
    	    {3, 4, 2, 5},  // Q4
    	    {3, 4, 2, 5}   // Q5
    	};


    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Hat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        BackgroundPanel panel = new BackgroundPanel("assets/background.jpg", "assets/logo.png");
        panel.setLayout(null);
        frame.setContentPane(panel);

        
        
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("assets/music.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY); 
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        
        
        
        JPanel questionCard = new JPanel();
                
        questionCard.setLayout(new BoxLayout(questionCard, BoxLayout.Y_AXIS)); //vertical top to bottom
        questionCard.setOpaque(false);
        questionCard.setBounds(250, 220, 1000, 500);
        panel.add(questionCard);

        JLabel questionLabel = new JLabel();
        questionLabel.setFont(new Font("Serif", Font.BOLD, 34));

        questionLabel.setOpaque(true);
        questionLabel.setBackground(new Color(0, 0, 0, 60)); // Translucent black background for the question 

        questionLabel.setForeground(Color.WHITE);
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //horizontal alignment
        questionCard.add(questionLabel);
        questionCard.add(Box.createRigidArea(new Dimension(0, 30))); //spaces

        JRadioButton[] options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();

//        try {
//            Font hogwartsFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font.TTF")).deriveFont(55f); // Adjust size
//            questionLabel.setFont(hogwartsFont);
//        } catch (Exception e) {
//            e.printStackTrace(); // Handle exception if font loading fails
//        }

        
        
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Dialog", Font.BOLD, 22));
            options[i].setForeground(Color.WHITE);
            options[i].setOpaque(false);
            
            
            options[i].setFocusPainted(false); //would show focus box
            options[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            group.add(options[i]);
            questionCard.add(options[i]);
            questionCard.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("SansSerif", Font.BOLD, 22));
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setFocusPainted(false);
        nextButton.setBackground(new Color(93, 63, 211));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); //button inside padding
        questionCard.add(Box.createRigidArea(new Dimension(0, 30)));
        questionCard.add(nextButton);

        JButton recheckButton = new JButton("Restart Quiz");
        recheckButton.setFont(new Font("SansSerif", Font.BOLD, 22));
        recheckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        recheckButton.setFocusPainted(false);
        recheckButton.setBackground(new Color(93, 63, 211));
        recheckButton.setForeground(Color.WHITE);
        recheckButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        recheckButton.setEnabled(false);  // Initially disabled
        questionCard.add(Box.createRigidArea(new Dimension(0, 30)));
        questionCard.add(recheckButton);
        
        
        // Function to update the question and options
        Runnable updateQuestion = () -> {
            questionLabel.setText(questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(answers[currentQuestion][i]);
                group.clearSelection();
            }
        };

        // Initial setup
        updateQuestion.run();

        nextButton.addActionListener(e -> {
            int selected = -1;
            for (int i = 0; i < 4; i++) {
                if (options[i].isSelected()) {
                    selected = i;
                    break;
                }
            }

            if (selected == -1) {
                JOptionPane.showMessageDialog(frame, "You are confusing the hat :(\nPlease select an option!", "Sorting Hat Confused !!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int[] housePoints = points[currentQuestion];
            switch (selected) {
                case 0 -> G += housePoints[0];
                case 1 -> R += housePoints[1];
                case 2 -> H += housePoints[2];
                case 3 -> S += housePoints[3];
            }

            currentQuestion++;
            if (currentQuestion < questions.length) {
                updateQuestion.run();
            } else {
                String house = getTopHouse();
                JOptionPane.showMessageDialog(frame, "You've been sorted into... " + house + "!", "House Result", JOptionPane.INFORMATION_MESSAGE);
                nextButton.setEnabled(false); // prevent more clicks
                recheckButton.setEnabled(true);
            }
        });
        
        recheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                G = 0;
                R = 0;
                H = 0;
                S = 0;
                
                currentQuestion = 0;

                nextButton.setEnabled(true);
                recheckButton.setEnabled(false);

                updateQuestion.run();
            }
        });
        
        


        frame.setVisible(true);
    }

    static String getTopHouse() {
        int max = Math.max(Math.max(G, R), Math.max(H, S));
        if (G == max) return "🦁 Gryffindor: Courage, bravery, and determination make you a true Gryffindor! \nYou face challenges head-on and never back down.";
        else if (R == max) return "🦅 Ravenclaw: Intelligence, wisdom, and creativity define you as a Ravenclaw! \nYou value knowledge and always seek the truth.";
        else if (H == max) return "🦡 Hufflepuff: Kindness, loyalty, and hard work are your guiding principles. \nYou always put others before yourself.";
        else return "🐍 Slytherin: Ambition, cunning, and resourcefulness make you a Slytherin! \nYou know how to make your own path to success.";
    }

}
