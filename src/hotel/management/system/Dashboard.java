package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JMenuItem reception, addemployee, addrooms, adddrivers;

    public Dashboard() {

        setLayout(null);

//        int width = Toolkit.getDefaultToolkit().getScreenSize().width; //Get default screen width
//        int height = Toolkit.getDefaultToolkit().getScreenSize().height; //Get default screen height
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 60, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 45));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.blue);
        mb.add(admin);

        addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        addrooms = new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        adddrivers = new JMenuItem("Add Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setBounds(0, 0, 1550, 1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addemployee) {
            new AddEmployee();
        } else if (ae.getSource() == addrooms) {
            new AddRooms();
        } else if (ae.getSource() == adddrivers) {
            new AddDriver();
        } else if (ae.getSource() == reception) {
            new Reception();
        }
    }
}
