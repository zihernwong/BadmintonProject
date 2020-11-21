
import java.util.NoSuchElementException;
import java.util.*;
/**
 * @author wongz
 * implements QueueADT <BoardingGroup>
 * This class is a ride queue which has various methods to add BoardingGroups to the Queue,
 * and remove BoardingGroups to the queue
 */
public class BadmintonQueue implements QueueADT <BadmintonGroup>{
	private int counter;
	private BGNode front; //head
	private BGNode back;//tail
	private int numOfGroups;//size
	public BadmintonQueue() {
		front = null;
		back = null;//initializes all of them
		numOfGroups = 0;
		counter = 0;
	}
	/**
	 *@return boolean toReturn-returns whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean toReturn = false;
		if(numOfGroups ==0) { //numOfGroups is basically the size
			toReturn = true;
		}
		return toReturn;
	}
	/**
	 *@throws java.lang.IllegalStateException - If the newGroup cannot fit into the queue.
	 */
	@Override
	
	public void enqueue(BadmintonGroup newObject) throws java.lang.IllegalStateException{
		//can add
		BGNode runner = front;
		if(newObject!=null) {
				
				if(front != null) {//means someone is already in line {
					if(numOfGroups==1) {//if size = 1
							runner = new BGNode (newObject);
						
						this.front.setNext(runner);
						this.back = runner;//sets the newObj to the back of the line
						//this.back.setNext(null);
						numOfGroups++;
						System.out.println(numOfGroups);
						
						}
					
					else if(numOfGroups>=2) {

					
						runner = new BGNode(newObject);
						this.back.setNext(runner);
						this.back = runner;//sets the newObj to the back of the line
						//this.back.setNext(null);
						numOfGroups++;
					}	
				}
				
			else {//the line is empty
				runner = new BGNode (newObject);
				this.front = runner;//sets the front and back to the new object
				this.back = runner;
				//this.back.setNext(null);
				numOfGroups++;//increment size 
			}	
			
			}//if there is no room to add
		
		
			
	}
	
	
	public void setName(BadmintonGroup BG) {
		G
		BG.setName(setter);
	}
	public void clear() {
		front = null;//sets everything to the default constructor
		back = null;
		numOfGroups = 0;
		
	}
	
	public BadmintonGroup engroup() {
		BadmintonGroup newGroup = new BadmintonGroup();
		
		return newGroup;
	}
	/**
	 * @throws NoSuchElementException if queue is empty
	 *@return type BoardingGroup returns the BoardingGroup at the front
	 */
	@Override
	public BadmintonGroup peek() throws java.util.NoSuchElementException{
		if(numOfGroups==0) {
			throw new NoSuchElementException("Queue is empty");
		}
		return this.front.getGroup(); //just get the group of the first person in line
	}

	/**@return type BoardingGroup returns the BoardingGroup that was removed
	 *@throws NoSuchElementException if the queue is empty
	 */
	@Override
	public BadmintonGroup dequeue() throws java.util.NoSuchElementException{
		BadmintonGroup toReturn = new BadmintonGroup();
		BadmintonGroup tempBG = new BadmintonGroup();
		BadmintonGroup newFront = new BadmintonGroup();
		if(this.front==null) {//for size==0
			throw new NoSuchElementException("Queue is Empty, nothing to remove");
		}
		else if(numOfGroups==1) {//after dequeue there should be no groups left
			toReturn = peek();//sets toReturn to the first item in the queue 
			this.front=null;
			this.back=null;
			numOfGroups=0;
		}
		else if(numOfGroups==2) {//should only have one group left after dequeue
			// group so front and back should be set to the one remaining group
			toReturn = peek();
			BGNode fron = new BGNode (newFront);
			fron = this.front.getNext();
			this.back= fron;//sets the remaining BoardingGroup to the front and back as only one group remains
			this.front = fron;
			numOfGroups--;//decrements numOfGroups
		}
		else{//guarenteed to have a .getnext.getnext
			if(this.front.getNext() != null && this.front.getNext().getNext()!=null) {
		toReturn = peek();
		BGNode fron = new BGNode(newFront); 
		fron = this.front.getNext();
		BGNode nn = new BGNode(tempBG);
		nn = fron.getNext();
		this.front = fron;
		this.front.setNext(nn);
		numOfGroups--;//decrements numOfGroups
			}
		}
		return toReturn;
	}

	// Returns a string representation of this RideQueue.
	/**
	 *@return type String returns String representation of the group
	 */
	public String toString() {
	String s = "Number of Groups in Queue: " + numOfGroups + "\n";
	s += "Group Names in Queue: ";
	
	BGNode current = front;
	
	while (current != null) {//not at the end, prevents out of bounds
	String groupName = current.getGroup().getName();
	s += groupName + " ";
	current = current.getNext();
	}
	return s;
	}
	public int counter() {
		if(counter <200) {
			return counter;
		}
		else {
			counter%=200;
			return counter;
		}
	}
	public static void main(String [] args) {
		BadmintonQueue BQ = new BadmintonQueue();
		BadmintonPlayer BP1 = new BadmintonPlayer ("Hern");
		BadmintonPlayer BP2 = new BadmintonPlayer ("John");
		BadmintonPlayer BP3 = new BadmintonPlayer ("Jack");
		BadmintonPlayer BP4 = new BadmintonPlayer ("Jake");
		BadmintonGroup J = new BadmintonGroup(BP1);
		BadmintonGroup H = new BadmintonGroup(BP2, BP3);
		BadmintonGroup G = new BadmintonGroup(BP4);
		BQ.enqueue(J);
		BQ.enqueue(H);
		BQ.enqueue(G);
		//BQ.enqueue(G);
		BQ.dequeue();
		System.out.println(BQ.toString());
		//System.out.println("First in Line: " + RQ.peek().getName());
		
	}
}
