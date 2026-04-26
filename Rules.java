package QuizApplication.icons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    public Rules(String name) {
        this.name = name;

        // Frame Settings
        setTitle("Quiz Rules");
        setSize(840, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Welcome Label
        JLabel wel = new JLabel("Welcome " + name + " to Simple Minds");
        wel.setBounds(170, 20, 600, 45);
        wel.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        wel.setForeground(new Color(30, 144, 255));
        add(wel);

        // Rules Title
        JLabel title = new JLabel("Rules");
        title.setBounds(100, 70, 240, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(30, 144, 255));
        add(title);

        // Rules Content
        JLabel rulesLabel = new JLabel();
        rulesLabel.setBounds(50, 110, 720, 300);
        rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rulesLabel.setForeground(Color.BLACK);
        rulesLabel.setText(
                "<html>" +
                        "1. You are trained to be a programmer and not a storyteller, answer point to point.<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you. They may also not know the answer.<br><br>" +
                        "3. You may have a lot of options in life but here all the questions are compulsory.<br><br>" +
                        "4. Crying is allowed but please do so quietly.<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise).<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions.<br><br>" +
                        "7. Brace yourself, this quiz is not for the faint-hearted.<br><br>" +
                        "8. May you know more than what Jon Snow knows. Good Luck!<br>" +
                        "</html>"
        );
        add(rulesLabel);

        // Back Button
        back = new JButton("Back");
        back.setBounds(250, 440, 120, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        // Start Button
        start = new JButton("Start");
        start.setBounds(450, 440, 120, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Arial", Font.BOLD, 14));
        start.addActionListener(this);
        add(start);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
