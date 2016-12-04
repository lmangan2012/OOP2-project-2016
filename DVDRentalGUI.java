import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class DVDRentalGUI extends JFrame implements ActionListener{
    // private instance variables
    JButton oneButton, twoButton;
    JLabel welcomeLabel,headingLabel;
    JPanel headingPanel,mainPanel;
    JMenu customerMenu,dvdMenu,exitMenu;
    JMenuItem item1,item2,item3,item4,item5,item6,item7,exitItem;
    
    String custName, custAddress, title, genre, rating;
    int age, year;
    double price;
    
    
    

    /** driver */
    public static void main (String [] args) {  
		DVDRentalGUI dvd = new DVDRentalGUI();
        dvd.setVisible(true);
    }

    public DVDRentalGUI () {
        setTitle ("DVD Main Menu");
        setSize (600,600);
        setResizable(false);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
       

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JPanel headingPanel = new JPanel(new GridBagLayout());
        JLabel headingLabel = new JLabel("Parkway DVD Rental Store");
        headingPanel.add(headingLabel);
        headingLabel.setFont(new Font("Serif", Font.ITALIC, 35));	
        	
        headingPanel.setPreferredSize(new Dimension(500,200));
        headingPanel.setBackground (Color.PINK);
        contentPane.add(headingPanel,BorderLayout.NORTH);
        

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
                                               
                                               
        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        
        mainPanel.setPreferredSize(new Dimension(500,200));
        mainPanel.setBackground (Color.YELLOW);
       
        welcomeLabel = new JLabel("<html><p>Welcome to the Parkway DVD Rental store.</p> <br/> " +
        						"<p>Staff can select an option from the menu above to manage the database.</p><br/> " +
        						 "<p>Customers can press the button below to rent a DVD.</p><br/><br/><br/></html>");
        
         //Code Source: http://stackoverflow.com/questions/7861724/is-there-a-word-wrap-property-for-jlabel
        
        
        
        						 
        JButton rentButton = new JButton();
        rentButton.setText("Rent a DVD");

       
       	
       	mainPanel.add(welcomeLabel);
       	mainPanel.add(new JLabel("                          "));
       	                                                         
       	mainPanel.add(rentButton);
        
        customerMenu = new JMenu("Manage Customers");       
        dvdMenu = new JMenu("Manage DVDs");
        exitMenu = new JMenu("Exit");
        
        
        exitItem = new JMenuItem("Exit System");
        exitItem.addActionListener(this);
        
        item1 = new JMenuItem("Add Customer");
        item2 = new JMenuItem("Edit Customer");
        item3 = new JMenuItem("Remove Customer");
        item4 = new JMenuItem("Add DVD"); 
        item5 = new JMenuItem("Edit DVD");
        item6 = new JMenuItem("Remove DVD");
        
        
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);
        
       
        customerMenu.add(item1); 
        customerMenu.add(item2);
        customerMenu.add(item3);
        dvdMenu.add(item4);
        dvdMenu.add(item5);
        dvdMenu.add(item6);
        exitMenu.add(exitItem);
        
        JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        menuBar.add(customerMenu);
        menuBar.add(dvdMenu);
        menuBar.add(exitMenu);
        
    }

    public void actionPerformed(ActionEvent e) {
        String  menuName=e.getActionCommand();
        if (menuName.equals("Add Customer")) {
				custName = JOptionPane.showInputDialog("Please enter the customer's name:");
				 if (custName == null)
                {
                    // Code to use when CANCEL is PRESSED.
                    JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                }
                
                 else{
                	 custAddress = JOptionPane.showInputDialog("Please enter the customer's address:");
                	  	if (custAddress == null)
                			{
                    			// Code to use when CANCEL is PRESSED.
                    			JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
                		
                		else{
                			
                				age = Integer.parseInt(JOptionPane.showInputDialog("Please enter the customer's age (enter 0 to cancel):"));
             		
                						
                					if (age == 0)
                						{
                    						// Code to use when CANCEL is PRESSED
                    						
                    						JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			
                						}
                						
                					else{
                						    //JB - some suggestions
										    //Create a Customer object at this point - you'll need a Customer class for your project
										    //Add it to an array list of Customers
										    //You can set it up so that when the "Exit" menu item is selected, the Customer and DVD array lists
										    //are saved to a file on disk
                						
                						
                						JOptionPane.showMessageDialog (null, "The customer " + custName + " has been added to the database.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                						
                					}
                			
                			}	
                			
                			
                			
                 }
			}
			
			//JB - I would just omit this code completely because it gets executed immediately if the user selects anything other than the 
			//"Add Customer" menu item, creating a logical error and not allowing you to reach the desired code below
			
			/*else{
				
				System.exit(0);
				
			}*/
		
	//if (menuName.equals("Edit Customer")) {
			
			
           //welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        //} // end if
        
        //else{
			//System.exit(0);
				
			//}		
				
				
		//if (menuName.equals("Remove Customer")) {
           //welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        //} // end if
        
        //else{
				//System.exit(0);
				
			//}
			
			
			
		if (menuName.equals("Add DVD")) {
			
				title = JOptionPane.showInputDialog("Please enter the title of the DVD:");
				 	if (title.equals(null))
                 		{
                    		// Code to use when CANCEL is PRESSED.
                    		JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                 		}
                 
                 	else{
                	 		year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the year the DVD was made:"));
                	  			if (year == 0)
                					{
                    					// Code to use when CANCEL is PRESSED.
                    					JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                					}
                		
                				else{
                						genre = JOptionPane.showInputDialog("Please enter the genre of the DVD:");
				 							if (genre == null)
                								{
                    								// Code to use when CANCEL is PRESSED.
                    								JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                								}
                		
                 							else{
                 									rating = JOptionPane.showInputDialog("Please enter the rating of the DVD:");
				 										if (rating == null)
                											{
                    											// Code to use when CANCEL is PRESSED.
                    											JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                											}
                							
                										else{
                											//JB - made some small changes here
                												price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price of the DVD:"));
				 													if (price == 0)
                														{
                    														// Code to use when CANCEL is PRESSED.
                    														JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                														}
                							
                							
                													else{
                														    //JB - some suggestions
                														    //Create a DVD object at this point - you'll need a separate DVD class for your project, 
                														    //(I would rename this GUI class from dvd to DVDRentalGUI)
                														    //Add the DVD object to an array list of DVDs
                														    //You can set it up so that when the "Exit" menu item is selected, the Customer and DVD array lists
                														    //are saved to a file on disk
                														    
                															JOptionPane.showMessageDialog (null, "The DVD " + title + " has been added to the database.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                														}
                			
                											}	
                			
                			
                			
                 								}
									}
                 		}
			
			
         	}
        
        //JB - Again, I would just omit this completely for the same reason as outlined above
        /* 
        else{
				System.exit(0);	
			}*/		
				
			
			
			
      } // end actionperformed
        
        
        
        //else if (menuName.equals("Add DVD")) {
          	//title = JOptionPane.showInputDialog("Please enter the title of the DVD:");
			//year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the year the DVD was made:"));
			//genre = JOptionPane.showInputDialog("Please enter the genre of the DVD:");
			//rating = JOptionPane.showInputDialog("Please enter the rating of the DVD:");
			//price = Float.parseFloat(JOptionPane.showInputDialog("Please enter the price of the DVD:"));
			//JOptionPane.showMessageDialog (null, "The DVD has been added to the database.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
        //} // end else if
        //else if (menuName.equals("Edit DVD")) {
           //welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        //} // end else if
        //else if (menuName.equals("Remove DVD")) {
           //welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
        //} // end else if
        //else
        //{
           //welcomeLabel.setText("Menu Item '" + menuName + "' is selected.");
           //exit
        
           //System.exit(0);
           //end else
        //}	
}

           