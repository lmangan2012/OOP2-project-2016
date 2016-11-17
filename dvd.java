import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dvd extends JFrame{
    // private instance variables
    JButton oneButton;
    JLabel welcomeLabel;
    JMenu fileMenu;  
    JMenu editMenu;
    JMenuItem item1,item2;
    
    

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
        
    
        oneButton = new JButton("Rent DVD");
        oneButton.setBounds(150,150,100,50);
        contentPane.add(oneButton);
        
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Exit");
        
        item1 = new JMenuItem("New"); 
        item2 = new JMenuItem("Open...");
        
        fileMenu.add(item1);
        fileMenu.add(item2);
        
        JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        
        
        
        
        
      
        
  
        
     
    }
}