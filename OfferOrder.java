/**
 * Assignment #3 - COMP249 U - Due Date: April 11th 2016 
 * Wan Lan He - 29469419
 */

package assignment3;

public class OfferOrder extends Order {
	public OfferOrder(String id, double price, int volume){
		super(id, price, volume);
	}
	
	public OfferOrder(){
		super();
	}
	
	public String toString(){
		return "Off: "  + this.getPrice() + " " + this.getVolume();
	}
	
	
}
