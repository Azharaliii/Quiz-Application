package QuizApplication.icons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] useranswers = new String[10][1];

    JRadioButton opt1, opt2, opt3, opt4;
    JLabel question1, qno;
    ButtonGroup buttonGroup;
    JButton nextButton, submitButton, lifelineButton;

    String name;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    Quiz(String name) {
        this.name = name;
        setBounds(200, 50, 900, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Header Image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("QuizApplication/icons/quiz.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(900, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image1 = new JLabel(scaledIcon);
        image1.setBounds(0, 0, 900, 200);
        add(image1);

        // Sample Questions & Answers
        loadQuestions();

        // Question Number Label
        qno = new JLabel("1");
        qno.setBounds(100, 250, 50, 30);
        qno.setFont(new Font("Arial", Font.BOLD, 15));
        add(qno);

        // Question Text Label
        question1 = new JLabel();
        question1.setBounds(140, 250, 700, 30);
        question1.setFont(new Font("Arial", Font.BOLD, 15));
        add(question1);

        // Option Buttons
        opt1 = createOption(300);
        opt2 = createOption(330);
        opt3 = createOption(360);
        opt4 = createOption(390);

        // Grouping Radio Buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(opt1);
        buttonGroup.add(opt2);
        buttonGroup.add(opt3);
        buttonGroup.add(opt4);

        // Next Button
        nextButton = createButton("Next", 300, 490);
        nextButton.addActionListener(this);

        // Lifeline Button
        lifelineButton = createButton("50:50 Life Line", 500, 490);
        lifelineButton.addActionListener(this);

        // Submit Button
        submitButton = createButton("Submit", 700, 490);
        submitButton.setEnabled(false);
        submitButton.addActionListener(this);

        start(count);
        setVisible(true);
    }

    private JRadioButton createOption(int y) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(120, y, 700, 30);
        opt.setBackground(Color.WHITE);
        opt.setFont(new Font("Dialog", Font.BOLD, 15));
        add(opt);
        return opt;
    }

    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 150, 40);
        btn.setBackground(new Color(30, 144, 254));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(btn);
        return btn;
    }

    private void loadQuestions() {
        questions[0] = new String[]{"Which animal is known as the 'Ship of the Desert'?", "Camel", "Elephant", "Giraffe", "Lion"};
        questions[1] = new String[]{"How many colors are in a rainbow?", "Seven", "Five", "Ten", "Three"};
        questions[2] = new String[]{"Which is the largest ocean in the world?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"};
        questions[3] = new String[]{"What is the capital city of France?", "Paris", "Rome", "Berlin", "London"};
        questions[4] = new String[]{"Which planet is known as the 'Red Planet'?", "Mars", "Jupiter", "Venus", "Saturn"};
        questions[5] = new String[]{"What do bees make?", "Honey", "Milk", "Silk", "Wool"};
        questions[6] = new String[]{"Which is the fastest land animal?", "Cheetah", "Lion", "Gazelle", "Horse"};
        questions[7] = new String[]{"What do you call a baby dog?", "Puppy", "Kitten", "Calf", "Chick"};
        questions[8] = new String[]{"Which body part do you use to hear?", "Ears", "Eyes", "Nose", "Mouth"};
        questions[9] = new String[]{"How many legs does a spider have?", "Eight", "Six", "Four", "Ten"};

        answers[0][1] = "Camel";
        answers[1][1] = "Seven";
        answers[2][1] = "Pacific Ocean";
        answers[3][1] = "Paris";
        answers[4][1] = "Mars";
        answers[5][1] = "Honey";
        answers[6][1] = "Cheetah";
        answers[7][1] = "Puppy";
        answers[8][1] = "Ears";
        answers[9][1] = "Eight";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextButton) {
            ans_given = 1;
            if (buttonGroup.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = buttonGroup.getSelection().getActionCommand();
            }

            if (count == 8) {
                nextButton.setEnabled(false);
                submitButton.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == lifelineButton) {
            // Disable two incorrect options
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifelineButton.setEnabled(false);

        } else if (ae.getSource() == submitButton) {
            ans_given = 1;
            if (buttonGroup.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = buttonGroup.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }

            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 16));

        if (timer > 0) {
            g.drawString(time, 650, 300);
        } else {
            g.drawString("Times up!!", 650, 300);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            if (buttonGroup.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = buttonGroup.getSelection().getActionCommand();
            }

            if (count == 8) {
                nextButton.setEnabled(false);
                submitButton.setEnabled(true);
            }

            if (count == 9) {
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question1.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        buttonGroup.clearSelection();
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        timer = 15;
    }

    public static void main(String[] args) {
        new Quiz("Azhar");
    }
}
