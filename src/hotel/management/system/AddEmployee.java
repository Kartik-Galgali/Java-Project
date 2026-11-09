package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    public AddEmployee() {
        getContentPane().setBackground(Color.white);
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(80,30,100,20);
        add(name);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
