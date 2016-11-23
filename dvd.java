import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class dvd extends JFrame implements ActionListener,MenuListener{
    // private instance variables
    JButton oneButton, twoButton;
    JLabel welcomeLabel,response;
    JPanel imagePanel,newPanel,p;
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
        
        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(new JLabel("DVD Rental Store"));
        imagePanel.setPreferredSize(new Dimension(500,200));
        imagePanel.setBackground (Color.PINK);
        contentPane.add(imagePanel,BorderLayout.NORTH);
        

        

        JPanel newPanel = new JPanel();
        newPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        if (menuName.equals("Exit")) {
           System.exit(0);
        } // end if
        else {
           response.setText("Menu Item '" + menuName + "' is selected.");
        } // end else
    }
    
    public void menuCanceled(MenuEvent e){}
    
    public void menuDeselected(MenuEvent e){}
    
    public void menuSelected(MenuEvent e)
    {
    	//rent a DVD
    	System.out.println("Hi!");
    }
    

}