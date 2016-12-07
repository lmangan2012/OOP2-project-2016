import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class DVDRentalGUI extends JFrame implements Serializable, ActionListener{
    // private instance variables
    JButton rentButton;
    JLabel welcomeLabel,headingLabel;
    JPanel headingPanel,mainPanel;
    JMenu customerMenu,dvdMenu,exitMenu;
    JMenuItem item1,item2,item3,item4,item5,item6,item7,exitItem;
    ArrayList <Customer> customerArrayList = new ArrayList <Customer>();
    ArrayList <DVD> DVDArrayList = new ArrayList <DVD>();
   
    
    String custName, custAddress, title, genre, rating, customer;
    int age, year, count;
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
        mainPanel.setBackground (Color.PINK);
       
        welcomeLabel = new JLabel("<html><p>Welcome to the Parkway DVD Rental store.</p> <br/> " +
        						"<p>Staff can select an option from the menu above to manage the database.</p><br/> " +
        						 "<p>Customers can press the button below to rent a DVD.</p><br/><br/><br/></html>");
        
         //Code Source: http://stackoverflow.com/questions/7861724/is-there-a-word-wrap-property-for-jlabel
        
						 
        JButton rentButton = new JButton();
        rentButton.setText("Rent a DVD");
		rentButton.addActionListener(this);
       
       	
       	mainPanel.add(welcomeLabel);
       	mainPanel.add(new JLabel("                          "));
       	                                                         
       	mainPanel.add(rentButton);
        
        customerMenu = new JMenu("Manage Customers");       
        dvdMenu = new JMenu("Manage DVDs");
        exitMenu = new JMenu("Save and Exit");
        
        
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
        
        loadCustomers();
        loadDVDs();
     
    }
    
    	
   public void loadCustomers()
   {
   	 try{
   	 	 
    		String fileName = "customers.ser";
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			ArrayList <Customer> customerArrayList = (ArrayList <Customer>)is.readObject();
			
			/*The following code is just to verify that the customers that had been saved to the file are accessible now
			//after relaunching the application*/
			
			if(customerArrayList!=null)		
			for (int i = 0; i<customerArrayList.size(); i++){
            				JOptionPane.showMessageDialog(null, "Name: " + customerArrayList.get(i).getCustName() + "\nAddress: " + customerArrayList.get(i).getCustAddress() + "\nAge: " + customerArrayList.get(i).getCustAge());
        			}
					
					
					is.close();
						
    
		} catch (FileNotFoundException f) {
						f.printStackTrace();
						System.out.println("The file customers.ser has not yet been created");
				   } catch (IOException f) {
						f.printStackTrace();
				   } catch (ClassNotFoundException f) {
						f.printStackTrace();
				   }			   
   }
   
   public void loadDVDs()
   {
   	 try{
   	 	 
    		String fileName = "dvds.ser";
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			ArrayList <DVD> DVDArrayList = (ArrayList <DVD>)is.readObject();
			
			/*The following code to verify that the DVDs that had been saved to the file are accessible now
			after relaunching the application*/
			
			if(customerArrayList!=null)		
			for (int i = 0; i<DVDArrayList.size(); i++){
            				JOptionPane.showMessageDialog(null, "Title: " + DVDArrayList.get(i).getTitle() + "\nAddress: " + DVDArrayList.get(i).getYear() + "\nGenre: " + DVDArrayList.get(i).getGenre() +
            					 								"\nRating: " + DVDArrayList.get(i).getRating() + "\nPrice: " + DVDArrayList.get(i).getPrice());
        			}
					
					is.close();
						
    
		} catch (FileNotFoundException d) {
					d.printStackTrace();
					System.out.println("The file dvds.ser has not yet been created");
				} catch (IOException d) {
						d.printStackTrace();
				   } catch (ClassNotFoundException d) {
						d.printStackTrace();
				   }
				   
				   
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
                			        String ageAsString = JOptionPane.showInputDialog("Please enter the customer's age:");
                			        
                			        if(ageAsString.equals("") || ageAsString==null)
                			        	
                			        	   // Code to use when CANCEL is PRESSED.
                			               JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			        else
	                			        {
	                			        	age = Integer.parseInt(ageAsString);
	                			        	
                			       
                					
                						Customer customer = new Customer(custName,custAddress,age);
                						
                						customerArrayList.add(customer);
                						
                						 
                						for (int i = 0; i<customerArrayList.size(); i++){
            								JOptionPane.showMessageDialog(null, "Name: " + customerArrayList.get(i).getCustName() + "\nAddress: " + customerArrayList.get(i).getCustAddress() + "\nAge: " + customerArrayList.get(i).getCustAge());
        								}
                				
                						
                						JOptionPane.showMessageDialog (null, "The customer " + custName + " has been added to the database.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                						
                					}
                			
                			}	
                			
                			
                			
                 }
			}
        
			
		
	if (menuName.equals("Edit Customer")) {
		 for (int i = 0; i<customerArrayList.size(); i++){
            customerArrayList.get( i);
            JOptionPane.showMessageDialog(null, "Name: " + customerArrayList.get(i).getCustName() + "\nAddress: " + customerArrayList.get(i).getCustAddress() + "\nAge: " + customerArrayList.get(i).getCustAge());
        }
		
		String searchCustName = JOptionPane.showInputDialog("Please enter customer name to search for:");
			for (int i = 0; i<customerArrayList.size(); i=i+1){
				if(searchCustName.equalsIgnoreCase(customerArrayList.get(i).getCustName())){
					JOptionPane.showMessageDialog(null, "Name: " + customerArrayList.get(i).getCustName() + "\nAddress: " + customerArrayList.get(i).getCustAddress() + "\nAge: " + customerArrayList.get(i).getCustAge());	
				}
            	
        	}
		
		String editCustomer = JOptionPane.showInputDialog("Please enter detail to change(name,address,age):");
			
					if (editCustomer.equals("name"))
                			{
                				custName = JOptionPane.showInputDialog("Please enter the new name:");
                    			//customerArrayList.set(0,0);
                    
                    			JOptionPane.showMessageDialog (null, "The name has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
                
                 	if (editCustomer.equals("address"))
                			{
                				String newCustAddress = JOptionPane.showInputDialog("Please enter the new address:");
                    			// customerArrayList.set(0,1);
                    			JOptionPane.showMessageDialog (null, "The address has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
			
					if (editCustomer.equals("age"))
                			{
                				String newAgeAsString = JOptionPane.showInputDialog("Please enter the new age:");
                				int newAge = Integer.parseInt(newAgeAsString);                    			// customerArrayList.set( 2, "New" );
                    			// customerArrayList.set(0,2);
                    			JOptionPane.showMessageDialog (null, "The age has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
        } // end if
        
        
				
		if (menuName.equals("Remove Customer")) {
           		//customerArrayList.remove(customer);
           
    
        } // end if
        
        
			
			
			
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
                												price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price of the DVD:"));
				 													if (price == 0)
                														{
                    														// Code to use when CANCEL is PRESSED.
                    														JOptionPane.showMessageDialog (null, "The process has been cancelled", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                														}
                							
                							
                													else{
         
                															DVD dvd = new DVD(title,year,genre,rating,price);
                																DVDArrayList.add(dvd);
                						
                						 
                															for (int i = 0; i<DVDArrayList.size(); i++){
            																		JOptionPane.showMessageDialog(null, "Title: " + DVDArrayList.get(i).getTitle() + "\nYear: " + DVDArrayList.get(i).getYear() + "\nGenre: " + DVDArrayList.get(i).getGenre() + 
            																											"\nRating: " + DVDArrayList.get(i).getRating() + "\nPrice: " + DVDArrayList.get(i).getPrice());
        																			}
                														    
                															JOptionPane.showMessageDialog (null, "The DVD " + title + " has been added to the database.", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                														}
                			
                											}	
                			
                			
                			
                 								}
									}
                 		}
			
			
         	}
         	
         	
         if (menuName.equals("Edit DVD")) {
         	
		String editDVD = JOptionPane.showInputDialog("Enter detail to change(title,year,genre,rating,price):");
			
					if (editDVD.equals("title"))
                			{
                				String newTitle = JOptionPane.showInputDialog("Please enter the new title:");
                    			 //DVDArrayList.set(0,0);
                    			JOptionPane.showMessageDialog (null, "The detail has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
                
                 	if (editDVD.equals("year"))
                			{
                				String newYearAsString = JOptionPane.showInputDialog("Please enter the new year:");
                				int newYear = Integer.parseInt(newYearAsString);
                    			// DVDArrayList.set(0,1);
                    			JOptionPane.showMessageDialog (null, "The detail has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
			
					if (editDVD.equals("genre"))
                			{
                				String newGenre = JOptionPane.showInputDialog("Please enter the new genre:");		// customerArrayList.set( 2, "New" );
                    			// DVDArrayList.set(0,2);
                    			JOptionPane.showMessageDialog (null, "The detail has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
                			
                	if (editDVD.equals("rating"))
                			{
                				String newRating = JOptionPane.showInputDialog("Please enter the new rating:");
                    			// DVDArrayList.set(0,3);
                    			JOptionPane.showMessageDialog (null, "The detail has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
                			
                	if (editDVD.equals("price"))
                			{
                				String newPriceAsString = JOptionPane.showInputDialog("Please enter the new price:");
                				double newPrice = Double.parseDouble(newPriceAsString);
                    			// DVDArrayList.set(0,4);
                    			JOptionPane.showMessageDialog (null, "The detail has been changed", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
                			}
        } // end if
        
         if (menuName.equals("Remove DVD")) {
          //customerArrayList.remove(customer);
        } // end if
        
        	
		if (menuName.equals("Exit System")) {
			
			
			try{
			String fileName = "customers.ser";
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
				os.writeObject(customerArrayList);
				JOptionPane.showMessageDialog (null, "Wrote Customers", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
				os.close();
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			} catch (IOException f) {
				f.printStackTrace();
			}
			
			
			try{
			String fileName = "dvds.ser";
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
				os.writeObject(DVDArrayList);
				JOptionPane.showMessageDialog (null, "Wrote DVDs", "Confirmation Message", JOptionPane.INFORMATION_MESSAGE);
				os.close();
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			} catch (IOException f) {
				f.printStackTrace();
			}		
 
           System.exit(0);
        } 		  				
      } // end menu actionperformed
      
//private class RentButtonListener implements ActionListener {
	 //public void actionPerformed(ActionEvent e)
	  	//{
	  		//String searchCustName = JOptionPane.showInputDialog("Please enter customer name to search for:");
			//for (int i = 0; i<customerArrayList.size(); i=i+1){
				
				
				
			//}
	  		
	  	//}
    //}// end buttonlistener inner class


        
}

           