package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkintime;

    public AddCustomer() {
        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 800, 550);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        text.setBounds(100, 20, 300, 30);
        add(text);
        
        JLabel lbid = new JLabel("ID");
        lbid.setFont(new Font("Raleway", Font.PLAIN, 20));
        lbid.setBounds(35, 80, 100, 20);
        add(lbid);
        
        String [] options = {"Aadhar Card", "Passport", "Driving Licence", "Voter Id Card", "Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblnumber.setBounds(35, 120 , 100, 20);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblname.setBounds(35, 160 , 100, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblgender.setBounds(35, 200 , 100, 20);
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(200, 200, 60, 25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270, 200, 70, 25);
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblcountry.setBounds(35, 240 , 100, 20);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
        lblroom.setBounds(35, 280 , 100, 20);
        add(lblroom);
        
        croom = new Choice();
        croom.setBounds(200, 280, 150, 25);
        add(croom);
        
        try {
            Conn conn = new Conn();
            String query = "Select * from room";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setFont(new Font("Raleway", Font.PLAIN, 20));
        lbltime.setBounds(35, 320 , 100, 20);
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel(""+date);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 16));
        checkintime.setBounds(200, 320 , 150, 20);
        add(checkintime);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
