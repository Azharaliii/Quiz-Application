package QuizApplication.icons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton back, jb;
    JTextField tf;

    Login() {
        // Load Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("QuizApplication/icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 400, 480);
        add(image);

        // Heading
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(460, 60, 300, 45);
        heading.setFont(new Font("Bradley Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 255));
        add(heading);

        // Name Label
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(500, 150, 240, 30);
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setForeground(new Color(30, 144, 255));
        add(name);

        // Name Input Field
        tf = new JTextField();
        tf.setBounds(450, 200, 300, 25);
        tf.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        add(tf);

        // Rules Button
        jb = new JButton("Rules");
        jb.setBounds(450, 250, 130, 30);
        jb.setBackground(new Color(30, 144, 254));
        jb.setForeground(Color.WHITE);
        jb.addActionListener(this);
        add(jb);

        // Back Button
        back = new JButton("Back");
        back.setBounds(600, 250, 130, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Frame Settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800, 500);
        setLocation(250, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jb) {
            String name = tf.getText().trim();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your name!");
            } else {
                setVisible(false);
                new Rules(name);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
