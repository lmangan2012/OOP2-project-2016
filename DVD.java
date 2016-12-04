//Customer.java

public class DVD{
	
	//declare attributes
	
	private String title;
	private int year;
	private String genre;
	private String rating;
	private double price;
	
	
	//constructor method 1 references constructor method 2 
	
	//constructor method 1 (empty constructor)
	
	public DVD(){
		title = "No Title Supplied";
		year = 0;
		genre = "No Genre Supplied";
		rating = "No Rating Supplied";
		price = 0.00;
	}
	
	
	//constructor method 2 (4-argument constructor)
	
	public DVD(String title, int year, String genre, String rating, double price){
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
		this.price = price;
	}
		
	
	//mutator method
	
	/**sets the title of a DVD object**/
		
	public void setTitle(String title){
		this.title = title;
	}
	
	/**sets the year of a DVD object
	
	*@param year year of a DVD**/
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	public void setRating(String rating){
		this.rating = rating;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
		
	//accessor method
	
	/**returns the title of a DVD object
	 *@param title title of a Customer**/
	
	public String getTitle(){
		return title;
	}
	
	public int getYear(){
		return year;
	}
	
	public String getGenre(){
		return genre;
	}
	
	public String getRating(){
		return rating;
	}
	
	public double getPrice(){
		return price;
	}
	
	
	//toString() method
	
	public String toString(){
		return "Title: " + getTitle() + "\nYear: " + getYear() + "\nGenre: " + getGenre() + "\nRating: " + getRating() + "\nPrice: " + getPrice();
	}
	
}	
	//create main class and object
	
	  class createDVD{
		public static void main(String args []){
			DVD d1 = new DVD();
			d1.setTitle("Love Actually");
			d1.setYear(2016);
			d1.setGenre("Rom-Com");
			d1.setRating("PG");
			d1.setPrice(12.99);
			System.out.println(d1.toString());	
		}
		
	}
	
	
