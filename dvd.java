import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class dvd extends JFrame implements ActionListener,MenuListener{
    // private instance variables
    JButton oneButton, twoButton;
    JLabel welcomeLabel,headingLabel;
    JPanel headingPanel,newPanel,p;
    JMenu fileMenu;  
    JMenu rentMenu;
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
        contentPane.setLayout(new BorderLayout());
        
        JPanel headingPanel = new JPanel(new FlowLayout());
        JLabel headingLabel = new JLabel("DVD Rental Store");
        headingPanel.add(headingLabel);
        headingPanel.setFont(new Font("Courier New", Font.ITALIC, 12));
        //label.setFont(new Font("Courier New", Font.ITALIC, 12));	
        	
        headingPanel.setPreferredSize(new Dimension(500,200));
        headingPanel.setBackground (Color.PINK);
        contentPane.add(headingPanel,BorderLayout.NORTH);
        

        JPanel newPanel = new JPanel();
        contentPane.add(newPanel, BorderLayout.CENTER);
        
        
        newPanel.setPreferredSize(new Dimension(500,200));
        newPanel.setBackground (Color.YELLOW);
       
       
        JLabel welcomeLabel = new JLabel("<html>Welcome to the Parkway DVD Rental shop. <br/> " +
        						"Please select an option from the menu above to avail of our many features.</html>");
        
        //Code Source: http://stackoverflow.com/questions/7861724/is-there-a-word-wrap-property-for-jlabel
       	
       	newPanel.add(welcomeLabel);
               
        fileMenu = new JMenu("DVD");
        rentMenu = new JMenu("Rent");
        
        item1 = new JMenuItem("Add DVD"); 
        item2 = new JMenuItem("Edit DVD");
        item3 = new JMenuItem("Remove DVD");
        item4 = new JMenuItem("Exit");
        
        
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        rentMenu.addMenuListener(this);
       
        fileMenu.add(item1); 
        fileMenu.add(item2);
        fileMenu.add(item3);
        fileMenu.add(item4);
        
        JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        menuBar.add(fileMenu);
        menuBar.add(rentMenu);
    }
    
//JMenuItem item1 = new JMenuItem(new AbstractAction("My Menu Item") {
    public void actionPerformed(ActionEvent e) {
        String  menuName=e.getActionCommand();
//        menuName = event.getActionCommand(); // what's written on the item that was clicked
        // note the String comparison
        if (item1.equals("Add DVD")) {
           welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        } // end if
        else if (item2.equals("Edit DVD")) {
           welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        } // end else if
        else if (item3.equals("Remove DVD")) {
           welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        } // end else if
        else {
           System.exit(0);
        } // end else
    }
    
    public void menuCanceled(MenuEvent e){}
    
    public void menuDeselected(MenuEvent e){}
    
    public void menuSelected(MenuEvent e)
    {
    	//rent a DVD
        dvd.setVisible(false);
        JFrame rentDVD = new JFrame();
       		rentDVD.setVisible(true);
        	rentDVD.setTitle ("Rent A DVD");
        	rentDVD.setSize (600,600);
        	rentDVD.setResizable(false);
        	rentDVD.setDefaultCloseOperation( EXIT_ON_CLOSE );
        	
        	
       
    }
    

}

           