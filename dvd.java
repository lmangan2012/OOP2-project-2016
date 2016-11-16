import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dvd extends JFrame {
    // private instance variables
    JButton oneButton;
    JLabel welcomeLabel;
    
    /** driver */
    public static void main (String [] args) {  
		dvd mine = new dvd();
        mine.setVisible(true);
    }

    public dvd () {
        setTitle ("DVD Main Menu (V2)");
        setSize (500, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        JLabel welcomeLabel = new JLabel("Welcome");
        contentPane.add(welcomeLabel);
        
        
        // construct two buttons
        oneButton = new JButton("Rent DVD");
        oneButton.setBounds(150,150,100,50);
        contentPane.add(oneButton);
        
     
    }
}