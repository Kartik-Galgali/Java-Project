package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfcompany, tfmodel, tfloc;
    JComboBox cbgender, cbavailable;
    JButton add, cancel;

    AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(250, 200, 980, 500);
        setLayout(null);

        JLabel heading = new JLabel("ADD DRIVER");
        heading.setBounds(150, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60, 60, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 60, 150, 30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        tfage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 160, 120, 30);
        add(lblgender);

        String[] genderOptions = {"Male", "Female"};
        cbgender = new JComboBox(genderOptions);
        cbgender.setBounds(200, 160, 150, 30);
        cbgender.setBackground(Color.white);
        cbgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cbgender);

        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcompany.setBounds(60, 210, 120, 30);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 210, 150, 30);
        tfcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfcompany);

        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblmodel.setBounds(60, 260, 120, 30);
        add(lblmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 260, 150, 30);
        tfmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfmodel);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 310, 120, 30);
        add(lblavailable);

        String[] clOptions = {"Available", "Busy"};
        cbavailable = new JComboBox(clOptions);
        cbavailable.setBounds(200, 310, 150, 30);
        cbavailable.setBackground(Color.white);
        cbavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cbavailable);

        JLabel lblLoc = new JLabel("Location");
        lblLoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLoc.setBounds(60, 360, 120, 30);
        add(lblLoc);

        tfloc = new JTextField();
        tfloc.setBounds(200, 360, 150, 30);
        tfloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfloc);

        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 410, 120, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(200, 410, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400, 70, 500, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddDriver();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            //Name
            String name = tfname.getText();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your name");
                return;
            }

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

            String gender = (String) cbgender.getSelectedItem();

            String company = tfcompany.getText();
            if (company.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your Company Name");
                return;
            }

            String model = tfmodel.getText();
            if (model.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your Model Name");
                return;
            }

            String availability = (String) cbavailable.getSelectedItem();

            String location = tfloc.getText();
            if (location.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your Address");
                return;
            }

            try {
                Conn conn = new Conn();
                String str = "Insert into driver value('" + name + "','" + age + "','" + gender + "','" + company + "','" + model + "','" + availability + "','" + location + "');";
                conn.s.executeUpdate(str);
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
}
