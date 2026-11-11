package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField tfroomno, tfprice;
    JComboBox cbavailable, cbclean, cbbedtype;
    JButton add, cancel;

    AddRooms() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(280, 250, 940, 470);
        setLayout(null);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        add(tfroomno);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String[] availableOptions = {"Available", "Occupied"};
        cbavailable = new JComboBox(availableOptions);
        cbavailable.setBounds(200, 130, 150, 30);
        cbavailable.setBackground(Color.white);
        cbavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cbavailable);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String[] clOptions = {"Cleaned", "Dirty"};
        cbclean = new JComboBox(clOptions);
        cbclean.setBounds(200, 180, 150, 30);
        cbclean.setBackground(Color.white);
        cbclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cbclean);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel lblbedtype = new JLabel("Bed Type");
        lblbedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbedtype.setBounds(60, 280, 120, 30);
        add(lblbedtype);

        String[] bedtype = {"Single Bed", "Double Bed"};
        cbbedtype = new JComboBox(bedtype);
        cbbedtype.setBounds(200, 280, 150, 30);
        cbbedtype.setBackground(Color.white);
        cbbedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cbbedtype);

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 330, 120, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(200, 330, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 60, 500, 300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddRooms();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomnumber = tfroomno.getText();
            String availability = (String) cbavailable.getSelectedItem();
            String cleaning = (String) cbclean.getSelectedItem();
            String price = tfprice.getText();
            String bedtype = (String) cbbedtype.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "Select * from room where roomnumber = '" + roomnumber + "';";
                ResultSet rs = c.s.executeQuery(query);
                if (!rs.next()) {
                    String str = "insert into room values('" + roomnumber + "','" + availability + "','" + cleaning + "','" + price + "','" + bedtype + "');";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Details Entered Successfully");
                    new AddRooms();
                } else {
                    JOptionPane.showMessageDialog(null, "Room Number already exist");
                    return;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
}
