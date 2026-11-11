package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    public HotelManagementSystem() {
//        setSize(1366, 565);
//        setLocation(100, 100);
        setBounds(100, 100, 1366, 565); //Creating Screen [x-axis, y-axis, width, height]
        setLayout(null); //Avoiding default Layout

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); //Importing image
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); //adding image background should match with screen size
        add(image); //Add image

        JLabel text = new JLabel("Hotel Management System"); //Creating Text
        int width = text.getFontMetrics(new Font("serif", Font.BOLD, 50)).stringWidth(text.getText()); //Fetching text width
        text.setBounds(20, 440, width + 10, 60); //  Text inside screen
        text.setForeground(Color.WHITE); //Text Color
        text.setFont(new Font("serif", Font.BOLD, 50)); //Font Format
        image.add(text); // add text in front of image

        JButton next = new JButton("Next"); //Creates button
        next.setBounds(1150, 450, 150, 50);
        next.setForeground(Color.MAGENTA); //Button Text Color
        next.setBackground(Color.WHITE); //Button Background
        next.addActionListener(this); //Button is clicked status
        next.setFont(new Font("arial", Font.PLAIN, 20));
        image.add(next); //Add button in front of text

        setVisible(true); //Screen Visible

        while (true) { //Text Blinking effect
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); //Old page closeed
        new Login(); //Login Page opened
    }

}
