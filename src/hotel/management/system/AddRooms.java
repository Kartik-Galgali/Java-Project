package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{

    JTextField tfroomno, tfprice;
    JComboBox cbavailable,cbclean,cbbedtype;
    JButton add, cancel;
    
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
        
        tfroomno = new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        add(tfroomno);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String [] availableOptions = {"Available","Occupied"};
        cbavailable = new JComboBox(availableOptions);
        cbavailable.setBounds(200, 130, 150, 30);
        cbavailable.setBackground(Color.white);
        cbavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cbavailable);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String [] clOptions = {"Cleaned","Dirty"};
        cbclean = new JComboBox(clOptions);
        cbclean.setBounds(200, 180, 150, 30);
        cbclean.setBackground(Color.white);
        cbclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cbclean);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        JLabel lblbedtype = new JLabel("Cleaning Status");
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblbedtype.setBounds(60, 280, 120, 30);
        add(lblbedtype);
        
        String [] bedtype = {"Single Bed","Double Bed"};
        cbbedtype = new JComboBox(bedtype);
        cbbedtype.setBounds(200, 280, 150, 30);
        cbbedtype.setBackground(Color.white);
        cbbedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cbbedtype);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 330, 120, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel Room");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(200, 330, 120, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            try {
                Conn c = new Conn();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Dashboard();
        }
    }
}
