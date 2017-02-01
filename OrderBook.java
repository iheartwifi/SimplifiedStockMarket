/**
 * Assignment #3 - COMP249 U - Due Date: April 11th 2016 
 * Wan Lan He - 29469419
 */

package assignment3;

import java.util.NoSuchElementException;

public class OrderBook implements Anonymous {
	
	private Node head;
	private Node tail;
	private int size;
	private Node bestOffer; // reference to best offer Node
	private Node bestBid; // reference to best bid Node
	private Order order;
	
	//Default constructor of OrderBook Class
	public OrderBook () {
		bestBid=null;
		bestOffer=null;
		size=0;
		head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
	}
	

	//Start Inner Node Class
	private class Node {
		public Order ord;
		public Node next;
		public Node previous;
		
		public Node(){
			ord=null;
			previous=null;
			next=null;
			
		}
		
		public Node(Order ord, Node previous, Node next){
			this.ord=ord;
			this.previous=previous;
			this.next=next;
			
		}

	} //End of private Node Inner Class	
	
	//Start of Iterator
	public class OrderBookIterator {
		private Node position;
		private Node previous;
		
		//constructor
		public OrderBookIterator (){
			position=head;

		}
		
		public void restart (){
			position=head;
		}
		
		public boolean hasNext(){
			return (position!=null);
		}
		
		public Order next(){
			if(!hasNext()) throw new NoSuchElementException();
			Order toReturn = position.ord;
			position = position.next;
			return toReturn;
		}
		
		public void insert(Order ord) {
			if (position ==null && head!=null) {
				Node temp = head; //add to end, first move a temp pointer to the end of the list
				while (temp.next !=null){
					temp=temp.next;
				}
				temp.next= new Node (ord, temp, null);
			}else if (head==null || position.previous==null) {
				OrderBook.this.addToStart(ord);
			}else {
				Node temp = new Node(ord, position.previous, position);	
				position.previous.next=temp;
				position.previous=temp;
				}
			}
		
		public void delete(){
			if(position==null) throw new IllegalStateException() ;
				else if(position.previous==null) {
					head=head.next;
					position=head;
				}else if (position.next==null){
					position.previous.next=null;
					position=null;
				}else{
					position.previous.next=position.next;
					position.next.previous=position.previous;
					position=position.next;
				}
		} 
			
	}//End of OrderBookIterator

	
	public OrderBookIterator iterate(){
		return new OrderBookIterator();
	}
		
	/**
	The added node will be the first node in the list.
	*/
	public void addToStart(Order ord){
		Node temp=  new Node(ord, null, head);
		if(head!=null){
			head.previous=temp;
		}
		head=temp;	
	}
	
	public void clear() {
		head=null;
	}
	

	
	public int size() {
		int count=0;
		Node position =head;
		while(position!=null){
			count++;
			position=position.previous; //next or previous
		}
		return count;
	}
		
	public void matchingEngine(Order ord) {	
		if (ord instanceof OfferOrder){
			 System.out.println("\nMatch new Order:\n" + ord.printFullDetails());
		}
		if(ord instanceof BidOrder){
			System.out.println("\nMatch found:\n"+ ord.printFullDetails());
				if(bestBid !=null && ord.getPrice() <= bestBid.ord.getPrice() && ord.getVolume() > 0){
					if ((ord.getVolume() - bestBid.ord.getVolume()) == 0) {; 
						 bestOffer=bestOffer.next;
						 delete(bestOffer.previous);
						 bestBid.ord.setVolume(0);
					}
					//The offer price is lower than the BidPrice, the volume of OfferOrder is ajusted
					//(offer volume minus the matched bestBid volume)		
					 ord.setVolume(ord.getVolume() - bestBid.ord.getVolume()); 
					 bestBid.ord.setVolume(0);
					 bestBid = bestBid.next;
					 delete(bestBid.next);
				}
				
				if (bestOffer == null || (bestOffer != null && ord.getPrice() >= bestOffer.ord.getPrice())){
				 	bestOffer=insert(ord);
				} else {
					 ord.setVolume(0);
					 delete(bestOffer);
						 if (bestBid.ord.getVolume() - ord.getVolume() > 0) {
							 bestBid.ord.setVolume(bestBid.ord.getVolume() - ord.getVolume());
						 } else {
							 bestBid.ord.setVolume(0);		 
							 delete(bestBid.next);
						 }
						 if (bestBid == null || (bestBid != null && ord.getPrice() >= bestBid.ord.getPrice())){
							 	bestOffer=insert(ord);
						 }	 
			 }
		}

	}
	
    private Node delete(Order ord2) {
		// TODO Auto-generated method stub
		return null;
	}

	private void delete(Node next) {
		// TODO Auto-generated method stub
		
	}

	private Node insert(Order ord2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
    Finds the first node containing the target item, and returns a
   	reference to that node. If target is not in the list, null is
   	returned. */
   
	private Node find(Order ord){
		Node position=head;
		Order ItemPosition;
		while (position!=null){
			ItemPosition = position.ord;
			if(ItemPosition.equals(ord)) {
				position=bestBid;
				return position;
			}
		}
		return null;
	}
    
	//Display the OrderBook on the screen
	public void outputBook(){
		System.out.println("\nOrder book: ");
		Node position = head.next;
		while (position!=null){
			System.out.println(position.ord);
			position=position.next; //next or previous
		}
	}
	
	
	//Displays the best bid and offer (BBO)
    public void outputBBO() {
        System.out.println("\nBest Bid & Offer: ");
        
        if(bestBid==null){
        	System.out.println("No best bids");
        }else {
        	System.out.println("Bid" + bestBid.ord.toString());
        }
        if(bestOffer==null){
        	System.out.println("No best offer");

        }else {
        	System.out.print("Off" + bestOffer.ord.toString());
        }
        System.out.println();
    }
	
}// End of OrderBook Class