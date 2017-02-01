/**
 * Assignment #3 - COMP249 U - Due Date: April 11th 2016 
 * Wan Lan He - 29469419
 */

package assignment3;

public class BidOrder extends Order {
	public BidOrder(String id, double price, int volume){
		super(id, price, volume);
	}
	
	public BidOrder(){
		super();
	}
	
	public String toString(){
		return "Bid: " + this.getPrice() + " " + this.getVolume();
	}
}
