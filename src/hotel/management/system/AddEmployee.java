package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit, cancel;
    JComboBox cbjob;

    public AddEmployee() {
        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
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
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String[] str = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        cbjob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(cbjob);

        JLabel lbsalary = new JLabel("Salary");
        lbsalary.setBounds(60, 230, 120, 30);
        lbsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(60, 280, 120, 30);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(60, 330, 120, 30);
        lbemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        JLabel lbaadhar = new JLabel("Aadhar No.");
        lbaadhar.setBounds(60, 380, 120, 30);
        lbaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);

        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setBounds(60, 430, 120, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(200, 430, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

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
        if (ae.getSource() == submit) {
            //Name
            String name = tfname.getText();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your name");
                return;
            }

            //Age
            String age = tfage.getText();
            if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Age");
                return;
            }
            int a;

            try {
                a = Integer.parseInt(age);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Plese Enter Valid Age");
                return;
            }
            if (a < 18) {
                JOptionPane.showMessageDialog(null, "You are not eligible");
                return;
            }

            //Gender
            String gender = null;

            if (rbmale.isSelected()) {
                gender = "Male";
            } else if (rbfemale.isSelected()) {
                gender = "Female";
            } else {
                JOptionPane.showMessageDialog(null, "Please Select Gender");
                return;
            }

            //Job
            String job = (String) cbjob.getSelectedItem();

            //Salary
            String salary = tfsalary.getText();
            if (salary.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Salary");
                return;
            }

            try {
                Integer.parseInt(salary);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please Enter Valid Salary");
                return;
            }

            //Phone
            String phone = tfphone.getText();
            if (salary.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Mobile Number");
                return;
            } else if (phone.length() != 10) {
                JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                return;
            } else {
                for (int i = 0; i < phone.length(); i++) {
                    char ch = phone.charAt(i);
                    if (!(Character.isDigit(ch))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Mobile Number");
                        return;
                    }
                }
            }

            //Email
            String email = tfemail.getText();
            if (email.equals("") || !(email.endsWith("@gmail.com") || email.endsWith("@email.com"))) {
                JOptionPane.showMessageDialog(null, "Please Enter Valid Email Id");
                return;
            }

            //Aadhar
            String aadhar = tfaadhar.getText();

            try {
                Conn c = new Conn();
                String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Detail Succeffully added");
                new AddEmployee();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }
}
