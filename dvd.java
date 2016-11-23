import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dvd extends JFrame{
    // private instance variables
    JButton oneButton, twoButton;
    JLabel welcomeLabel,test;
    JPanel imagePanel,newPanel,p;
    JMenu fileMenu;  
    JMenu editMenu;
    JMenuItem item1,item2,item3,item4;
    
    

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
        
        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(new JLabel(new ImageIcon("images/dvd_rental_shop.jpg")));
        imagePanel.setPreferredSize(new Dimension(500,200));
        imagePanel.setBackground (Color.PINK);
        
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground (Color.PINK);
        JLabel test = new JLabel("<html>Welcome to the Parkway DVD Rental shop. <br/> " +
        						"Please select an option from the menu above to avail of our many features.</html>");
        
        

        JPanel newPanel = new JPanel();
        newPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(newPanel, new GridBagConstraints());
        
        
        newPanel.setPreferredSize(new Dimension(500,200));
        newPanel.setBackground (Color.PINK);
       
       
        JLabel welcomeLabel = new JLabel("<html>Welcome to the Parkway DVD Rental shop. <br/> " +
        						"Please select an option from the menu above to avail of our many features.</html>");
        
        //Code Source: http://stackoverflow.com/questions/7861724/is-there-a-word-wrap-property-for-jlabel
       	
       	newPanel.add(welcomeLabel);
               
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Exit");
        
        item1 = new JMenuItem("Add DVD"); 
        item2 = new JMenuItem("Edit DVD");
        item3 = new JMenuItem("Remove DVD");
        item4 = new JMenuItem("Rent DVD");
        
       
        fileMenu.add(item1); 
        fileMenu.add(item2);
        fileMenu.add(item3);
        fileMenu.add(item4);
        
        JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        
        
        
        
        
      
        
  
        
     
    }
}