import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dvd extends JFrame{
    // private instance variables
    JButton oneButton, twoButton;
    JLabel welcomeLabel;
    JPanel newPanel,newPanel2;
    JMenu fileMenu;  
    JMenu editMenu;
    JMenuItem item1,item2;
    
    

    /** driver */
    public static void main (String [] args) {  
		dvd dvd = new dvd();
        dvd.setVisible(true);
    }

    public dvd () {
        setTitle ("DVD Main Menu");
        setSize (600,600);
        setResizable(false);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        

        JPanel newPanel = new JPanel();
        newPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(newPanel, new GridBagConstraints());
        
        
        newPanel.setPreferredSize(new Dimension(500,200));
        newPanel.setBackground (Color.PINK);
                 
        JLabel welcomeLabel = new JLabel("Welcome to the DVD store. Please" 
        						+ " select an option from the menu above.");
       	newPanel.add(welcomeLabel);
               
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