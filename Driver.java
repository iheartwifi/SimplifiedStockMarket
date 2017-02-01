/**
 * Assignment #3 - COMP249 U - Due Date: April 11th 2016 
 * Wan Lan He - 29469419
 */

package assignment3;

public class Driver {
	

	public static void main(String args []){
		     
		OrderBook book = new OrderBook ();
		OrderBook.OrderBookIterator obi = book.iterate();
	
		book.addToStart(new OfferOrder("1", 155, 300));
		book.addToStart(new OfferOrder("2", 152.5, 120));
		book.addToStart(new OfferOrder("3", 152, 100));
		
		book.addToStart(new BidOrder("Bob", 147.0, 200));
		book.addToStart(new BidOrder("Ishana", 146.6, 100));
		book.addToStart(new BidOrder("Feng", 148.0, 75));
		book.addToStart(new BidOrder("xxxx", 146.5, 50));
		
		Order o = new OfferOrder("Alice", 146.60, 500);	
		book.outputBook();

		
		book.matchingEngine(o);
		book.matchingEngine(new BidOrder("Bob", 147.0, 200));
		book.matchingEngine(new BidOrder("Ishana", 146.6, 100));
		book.matchingEngine(new BidOrder("Feng", 148.0, 75));
			
		book.outputBBO();
	    
	    }

	
}
