package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener {

    public Reception() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 800, 500);
        setVisible(true);
    } 
    
    public static void main(String[] args) {
        new Reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 
    }
}
