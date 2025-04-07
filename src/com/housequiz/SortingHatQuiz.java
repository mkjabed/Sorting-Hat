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
    	    "Which do you hate to be called?",
    	    "After you're gone, how should people remember you?",
    	    "How would you like to be known to history?",
    	    "Would you rather invent a potion for:",
    	    "What instrument pleases your ear?",
    	    "Which goblet would you choose?",
    	    "Which box would you try to open?",
    	    "Which challenge do you find most difficult?",
    	    "Which would you rather be?"
    	};

    	static String[][] answers = {
    	    // Options ordered as: [Gryffindor, Ravenclaw, Hufflepuff, Slytherin]
    	    {"Cowardly", "Ignorant", "Selfish", "Ordinary"},
    	    {"Ask for more stories", "Admire your achievements", "Miss you, but smile", "I Don't care at all"},
    	    {"The Bold", "The Wise", "The Good", "The Great"},
    	    {"Glory", "Wisdom", "Love", "Power"},
    	    {"Drum", "Piano", "Trumpet", "Violin"},
    	    {"Golden", "Silvery", "Purple", "Black"},
    	    {"Pewter box", "Golden casket", "Tortoiseshell box", "Black box"},
    	    {"Hunger", "Cold", "Loneliness", "Boredom"},
    	    {"Praised", "Envied", "Trusted", "Feared"}
    	};

    	static int[][] points = {
    	    // Points assigned in the order: [Gryffindor, Ravenclaw, Hufflepuff, Slytherin]
    	    {4, 3, 1, 2},   // Q1: "Which do you hate to be called?"
    	    {3, 2, 4, 1},   // Q2: "After you're gone, how should people remember you?"
    	    {1, 4, 2, 3},   // Q3: "How would you like to be known to history?"
    	    {3, 2, 4, 1},   // Q4: "Would you rather invent a potion for:"
    	    {4, 3, 2, 1},   // Q5: "What instrument pleases your ear?"
    	    {4, 3, 2, 1},   // Q6: "Which goblet would you choose?"
    	    {4, 3, 2, 1},   // Q7: "Which box would you try to open?"
    	    {4, 3, 2, 1},   // Q8: "Which challenge do you find most difficult?"
    	    {4, 3, 2, 1}    // Q9: "Which would you rather be?"
    	};

    	
    	


        static Clip clip = null;
    	
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Hat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        BackgroundPanel panel = new BackgroundPanel("assets/background.jpg", "assets/logo.png");
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setUndecorated(true);
        

        
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("assets/music.wav"));
            clip = AudioSystem.getClip(); // no redeclaration here
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        
        
        JPanel questionCard = new JPanel();
                
        questionCard.setLayout(new BoxLayout(questionCard, BoxLayout.Y_AXIS)); //vertical top to bottom
        questionCard.setOpaque(false);

        questionCard.setBounds(215, 220, 1100, 600);

        
        panel.add(questionCard);

        JLabel questionLabel = new JLabel();
        questionLabel.setFont(new Font("Serif", Font.BOLD, 32));

        questionLabel.setOpaque(true);
        questionLabel.setBackground(new Color(0, 0, 0, 60)); // Translucent black background for the question 

        questionLabel.setForeground(Color.WHITE);
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //horizontal alignment
        questionCard.add(questionLabel);
        questionCard.add(Box.createRigidArea(new Dimension(0, 30))); //spaces        
        
        JRadioButton[] options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();

        try {
            Font hogwartsFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font.TTF")).deriveFont(55f); // Adjust size
            questionLabel.setFont(hogwartsFont);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception if font loading fails
        }

        
        
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Monospaced", Font.BOLD, 28));
            options[i].setForeground(Color.WHITE);
            options[i].setOpaque(false);
            options[i].setFocusPainted(false); //would show focus box
            options[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            options[i].setContentAreaFilled(false);
            group.add(options[i]);
            questionCard.add(options[i]);
            questionCard.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        ImageIcon musicOnIcon = new ImageIcon(new ImageIcon("assets/pause.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        ImageIcon musicOffIcon = new ImageIcon(new ImageIcon("assets/play.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JButton musicButton = new JButton(musicOnIcon);
        musicButton.setBounds(1467, 25, 50, 50); 

        musicButton.setContentAreaFilled(false); 
        musicButton.setBorderPainted(false);    
        musicButton.setOpaque(false);           
        musicButton.setFocusPainted(false);
        frame.add(musicButton);


        
        musicButton.addActionListener(e -> {
            if (clip.isRunning()) {
                clip.stop();
                musicButton.setIcon(musicOffIcon);
            } else {
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                musicButton.setIcon(musicOnIcon);
            }
        });

        
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Dialog", Font.BOLD, 22));
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setFocusPainted(false);
        nextButton.setBackground(new Color(255, 255, 255));
        nextButton.setForeground(new Color(0, 48, 73));
        nextButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); //button inside padding
        questionCard.add(Box.createRigidArea(new Dimension(0, 30)));
        questionCard.add(nextButton);

        JButton recheckButton = new JButton("Restart");
        recheckButton.setFont(new Font("Dialog", Font.BOLD, 22));
        recheckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        recheckButton.setFocusPainted(false);
        recheckButton.setBackground(new Color(255, 255, 255));
        recheckButton.setForeground(new Color(0, 48, 73));
        recheckButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        recheckButton.setEnabled(false);  // Initially disabled
        questionCard.add(Box.createRigidArea(new Dimension(0, 30)));
        questionCard.add(recheckButton);
        
        
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Dialog", Font.BOLD, 22));
        exitButton.setFocusPainted(false);
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.setForeground(new Color(0, 48, 73));
        exitButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        
        questionCard.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel buttonRow = new JPanel();
        buttonRow.setOpaque(false);
        buttonRow.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0)); // horizontal, with gap

        buttonRow.add(recheckButton);
        buttonRow.add(exitButton);
        buttonRow.setAlignmentY(currentQuestion);
        questionCard.add(buttonRow);

        
        exitButton.addActionListener(e -> System.exit(0));
        
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
            	showErrorDialog(frame, "You are confusing the hat :(\nPlease select an option!");
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
                showCustomDialog(frame, house);
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

    
    
    private static void showErrorDialog(JFrame parent, String message) {
        JDialog dialog = new JDialog(parent, "Oops!", true);
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(0, 0, 0, 200));
        content.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel msgLabel = new JLabel("<html><div style='text-align: center;'>" + message.replace("\n", "<br>") + "</div></html>");
        msgLabel.setForeground(Color.WHITE);
        msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font.TTF")).deriveFont(26f);
            msgLabel.setFont(customFont);
        } catch (Exception e) {
            msgLabel.setFont(new Font("Arial", Font.BOLD, 24));
        }

        JButton okButton = new JButton("Got it");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setFocusPainted(false);
        okButton.setBackground(Color.WHITE);
        okButton.setForeground(new Color(0, 48, 73));
        okButton.setFont(new Font("Dialog", Font.BOLD, 20));
        okButton.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));
        okButton.addActionListener(e -> dialog.dispose());

        content.add(msgLabel);
        content.add(Box.createRigidArea(new Dimension(0, 25)));
        content.add(okButton);

        
        dialog.getContentPane().add(content);
        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        dialog.setVisible(true);
    }

    
    static String getTopHouse() {
    	int max = Math.max(Math.max(G, R), Math.max(H, S));
        if (G == max) return "Gryffindor\nYou face challenges head-on and never back down.";
        else if (R == max) return "Ravenclaw\nYou value knowledge and always seek the truth.";
        else if (H == max) return "Hufflepuff\nYou always put others before yourself.";
        else return "Slytherin\nYou know how to make your own path to success.";
    }


    private static void showCustomDialog(JFrame parent, String house) {
        JDialog dialog = new JDialog(parent, "House Result", true);
//        dialog.setUndecorated(true); // borderless

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
       
        content.setBackground(new Color(0, 0, 0, 200)); // translucent dark
        
        content.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel resultLabel = new JLabel("<html><div style='text-align: center;'>" + house.replace("\n", "<br>") + "</div></html>");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font.TTF")).deriveFont(32f);
            resultLabel.setFont(customFont);
        } catch (Exception e) {
            resultLabel.setFont(new Font("Arial", Font.BOLD, 28));
        }

        JButton okButton = new JButton("Yey!");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setFocusPainted(false);
        okButton.setBackground(Color.WHITE);
        okButton.setForeground(new Color(0, 48, 73));
        okButton.setFont(new Font("Dialog", Font.BOLD, 20));
        okButton.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));

        okButton.addActionListener(e -> dialog.dispose());

        content.add(resultLabel);
        content.add(Box.createRigidArea(new Dimension(0, 30)));
        content.add(okButton);

        dialog.getContentPane().add(content);
        dialog.pack();
        
        // Center the dialog on screen
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }
}

