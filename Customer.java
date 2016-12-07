//Customer.java
import java.io.Serializable;

public class Customer implements Serializable{

	
	//declare attributes
	
	private String custName;
	private String custAddress;
	private int custAge;
	
	
	//constructor method 1 references constructor method 2 
	
	//constructor method 1 (empty constructor)
	
	public Customer(){
		custName = "No Name Supplied";
		custAddress = "No Address Supplied";
		custAge = 0;
	}
	
	
	//constructor method 2 (4-argument constructor)
	
	public Customer(String custName, String custAddress, int custAge){
		this.custName = custName;
		this.custAddress = custAddress;
		this.custAge = custAge;
	}
		
	
	//mutator method
	
	/**sets the name of a Customer object
	 *@param name name of a customer**/
		
	public void setCustName(String custName){
		this.custName = custName;
	}
	
	/**sets the address of a Customer object
	 *@param address address of a customer**/
	
	public void setCustAddress(String custAddress){
		this.custAddress = custAddress;
	}
	
	/**sets the age of a Customer object
	 *@param age age of a customer**/
	
	public void setCustAge(int custAge){
		this.custAge = custAge;
	}
	
		
	//accessor method
	
	/**returns the name of a Customer object
	 *@param name name of a Customer**/
	
	public String getCustName(){
		return custName;
	}
	
	/**returns the address of a Customer object
	 *@param address address of a Customer**/
	public String getCustAddress(){
		return custAddress;
	}
	
	/**returns the age of a Customer object
	 *@param age age of a Customer**/
	public int getCustAge(){
		return custAge;
	}
	
	 
	//toString() method
	
	public String toString(){
		return "Name: " + getCustName() + "\nAddress: " + getCustAddress() + "\nAge: " + getCustAge();
	}
	
}	
	//create main class and object
	
	  class createCustomer{
		public static void main(String args []){
			Customer c1 = new Customer();
			c1.setCustName("Jane Lynch");
			c1.setCustAddress("Ennis");
			c1.setCustAge(23);
			System.out.println(c1.toString());	
		}
		
	}
	
	
