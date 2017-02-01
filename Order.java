/**
 * Assignment #3 - COMP249 U - Due Date: April 11th 2016 
 * Wan Lan He - 29469419
 */
package assignment3;

public class Order implements Anonymous {

	private String id;
	private double price;
	private int volume;
	
	public Order() {
	}
	
	public Order(String id, double price, int volume){
		this.id=id;
		this.price=price;
		this.volume=volume;
	}
	
	//Get and Set Methods
	public String getId(){
		return id;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getVolume(){
		return volume;
	}
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
	
	public void setVolume(int volume){
		this.volume=volume;
	}
	
	public String toString(){
		return "ID" + id + "price: " + price + "volume: " + volume;
	}
	

	public String printFullDetails(Order ord){
		return null;
	}
	
	//Override String method
	public String printFullDetails(){
		return this.toString() +" "+ id;
	}

	public boolean subtract(Order ord) {
	 if(this.volume >= ord.getVolume()) {
         System.out.println("delete " + ord.getVolume() + " from " + this.toString());
         this.volume -=ord.getVolume();
         return true;
     } else {
         return false;
     }
	 
	 
 }
}
