package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE); //Screen Background Color
        setLayout(null);
        setBounds(500,200,600,300);
        
        JLabel user = new JLabel("Username");
//        System.out.println(user.getFont());
        user.setBounds(40, 30, 100,30);
        add(user); //add username
        JTextField username = new JTextField(); //To add Text Field
        username.setBounds(150, 30, 150, 30);
        add(username); //add username textfield
        
        JLabel pass = new JLabel("Password");
//        System.out.println(pass.getFont()); //get font style 
        pass.setBounds(40, 70, 100,30);
        add(pass); //add password
        JTextField password = new JTextField(); //To add Text Field
        password.setBounds(150, 70, 150, 30);
        add(password); //add password textfield
        
        JButton login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setForeground(Color.white);
        login.setBackground(Color.black);
        add(login);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(170, 150, 120, 30);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); //Adjust image size
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
