package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        
        setLayout(null);
        
        int width = Toolkit.getDefaultToolkit().getScreenSize().width; //Get default screen width
        int height = Toolkit.getDefaultToolkit().getScreenSize().height; //Get default screen height
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, width, height);
        add(image);
        
        setBounds(0, 0, width, height);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
}
