//SponsoredCyclist.java
/*This program will input and display the cyclist's first name, initial, last name, distance cycled and
 *calculate the money due*/
 
 import javax.swing.JOptionPane; 

public class SponsoredCyclist {

	public static void main(String[] args){
		
		
		
		//input
		
		
		String firstName = JOptionPane.showInputDialog("Please enter your first name");
		
		String initial = JOptionPane.showInputDialog("Please enter your initial");
		
		String lastName = JOptionPane.showInputDialog("Please enter your last name");
		
		float distance = Float.parseFloat(JOptionPane.showInputDialog("Please enter the distance you cycled"));
		float moneyDue ;
		
		//processes
		
		if(distance <= 10){
			 moneyDue = distance * 7;	
		}
			
		else {
			float excessDistance = distance - 10;
			float distanceA = 10 * 7;
			float distanceB = excessDistance * 10;
			moneyDue = distanceA + distanceB;
		}
		 
		
		//output
		
		
		JOptionPane.showMessageDialog(null,"Your name is: " + firstName + initial + lastName + "The distance cycled was: " + distance + 
									  "\nThe money due is: " + moneyDue,"Money Due To Cyclist",JOptionPane.INFORMATION_MESSAGE);
	
	
	}
    
}