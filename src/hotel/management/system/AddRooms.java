package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{

    AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(330, 90, 940, 470);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);
        
        JTextField tfroomno = new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        add(tfroomno);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String [] availableOptions = {"Available","Occupied"};
        JComboBox cbavailable = new JComboBox(availableOptions);
        cbavailable.setBounds(200, 130, 150, 30);
        cbavailable.setBackground(Color.white);
        cbavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cbavailable);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String [] clOptions = {"Cleaned","Dirty"};
        JComboBox cbclean = new JComboBox(clOptions);
        cbclean.setBounds(200, 180, 150, 30);
        cbclean.setBackground(Color.white);
        cbclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cbclean);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
