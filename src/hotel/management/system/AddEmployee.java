package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    public AddEmployee() {
        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);
        
        String [] str = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff", "Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        cbjob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(cbjob);
        
        JLabel lbsalary = new JLabel("Salary");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(60,280,120,30);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(60,330,120,30);
        lbemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lbaadhar = new JLabel("Aadhar No.");
        lbaadhar.setBounds(60,380,120,30);
        lbaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);
        
        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        String gender = null;
        
        if(rbmale.isSelected()){
            gender = "Male";
        }
        else if(rbfemale.isSelected()){
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try {
            Conn c = new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"');";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Detail Succeffully added");
            setVisible(false);
            new Dashboard();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
