
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class HotelManagementSystem extends JFrame {

    public HotelManagementSystem() {
//        setSize(1366, 565);
//        setLocation(100, 100);
        setBounds(100, 100, 1366, 565);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 10, 700, 130);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.BOLD,50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setForeground(Color.MAGENTA);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("arial",Font.PLAIN,20));
        image.add(next);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
