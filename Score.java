package QuizApplication.icons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JButton playAgain;

    Score(String name, int score) {
        setBounds(200, 50, 900, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Score Image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("QuizApplication/icons/score.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image1 = new JLabel(scaledIcon);
        image1.setBounds(300, 30, 300, 200);
        add(image1);

        // Thank You Label
        JLabel wel = new JLabel("Thank You " + name + " for Playing Simple Minds");
        wel.setBounds(150, 250, 600, 45);
        wel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 28));
        wel.setForeground(new Color(30, 144, 255));
        add(wel);

        // Score Label
        JLabel scoreLabel = new JLabel("Your Score is: " + score);
        scoreLabel.setBounds(350, 320, 300, 30);
        scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(scoreLabel);

        // Play Again Button
        playAgain = new JButton("Play Again");
        playAgain.setBounds(375, 400, 150, 40);
        playAgain.setFont(new Font("Tahoma", Font.BOLD, 18));
        playAgain.setBackground(new Color(30, 144, 255));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
