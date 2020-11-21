	import java.util.NoSuchElementException;
	import java.util.*;
public class WaitList {
	private WLNode front; //head
	private WLNode back;//tail
	private int numOfPeople;//size

	public WaitList() {
			front = null;
			back = null;//initializes all of them
			numOfPeople = 0;
		}
		/**
		 *@return boolean toReturn-returns whether the queue is empty
		 */
		public boolean isEmpty() {
			boolean toReturn = false;
			if(numOfPeople ==0) { //numOfGroups is basically the size
				toReturn = true;
			}
			return toReturn;
		}

		/**
		 *@return int ret
		 */

		/**
		 *@throws java.lang.IllegalStateException - If the newGroup cannot fit into the queue.
		 */
		
		public void enqueue(BadmintonPlayer newObject) throws java.lang.IllegalStateException{
			//can add
		
			WLNode runner = front;
			
			if(newObject!=null) {
				
					if(front != null) {//means someone is already in line {
						if(numOfPeople==1) {//if size = 1
							
								runner = new WLNode (newObject);
							
							this.front.setNext(runner);
							this.back = runner;//sets the newObj to the back of the line
							//this.back.setNext(null);
							numOfPeople++;
							}
						
						else if(numOfPeople>1) {
						
							runner = new WLNode(newObject);
							this.back.setNext(runner);
							this.back = runner;//sets the newObj to the back of the line
							//this.back.setNext(null);
							numOfPeople++;
							}
						
					}
				else {//the line is empty
					
					runner = new WLNode (newObject);
					this.front = runner;//sets the front and back to the new object
					this.back = runner;
					//this.back.setNext(null);
					numOfPeople++;//increment size 
				}	
				
				}//if there is no room to add
			
			
				
			}
		
		

		public void clear() {
			front = null;//sets everything to the default constructor
			back = null;
			numOfPeople = 0;
			
		}
		/**
		 * @throws NoSuchElementException if queue is empty
		 *@return type BoardingGroup returns the BoardingGroup at the front
		 */

		public BadmintonPlayer peek() throws java.util.NoSuchElementException{
			if(numOfPeople==0) {
				throw new NoSuchElementException("Queue is empty");
			}
			return this.front.getPlayer(); //just get the group of the first person in line
		}

		/**@return type BoardingGroup returns the BoardingGroup that was removed
		 *@throws NoSuchElementException if the queue is empty
		 */
		public BadmintonPlayer dequeue() throws java.util.NoSuchElementException{
			BadmintonPlayer toReturn = new BadmintonPlayer("start");
			BadmintonPlayer tempBG = new BadmintonPlayer("start");
			BadmintonPlayer newFront = new BadmintonPlayer("front");
			if(this.front==null) {//for size==0
				throw new NoSuchElementException("Queue is Empty, nothing to remove");
			}
			else if(numOfPeople==1) {//after dequeue there should be no groups left
				toReturn = peek();//sets toReturn to the first item in the queue 
				this.front=null;
				this.back=null;
				numOfPeople=0;
			}
			else if(numOfPeople==2) {//should only have one group left after dequeue
				// group so front and back should be set to the one remaining group
				toReturn = peek();
				WLNode fron = new WLNode (newFront);
				fron = this.front.getNext();
				this.back= fron;//sets the remaining BoardingGroup to the front and back as only one group remains
				this.front = fron;
				numOfPeople--;//decrements numOfGroups
			}
			else{//guarenteed to have a .getnext.getnext
				if(this.front.getNext() != null && this.front.getNext().getNext()!=null) {
			toReturn = peek();
			WLNode fron = new WLNode(newFront); 
			fron = this.front.getNext();
			WLNode nn = new WLNode(tempBG);
			nn = fron.getNext();
			this.front = fron;
			this.front.setNext(nn);
			numOfPeople--;//decrements numOfGroups
				}
			}
			return toReturn;
		}

		// Returns a string representation of this RideQueue.
		/**
		 *@return type String returns String representation of the group
		 */
		public String toString() {
		String s = "Number of PLayers in Queue: " + numOfPeople + "\n";
		s += "Players in Queue: ";
		WLNode current = front;
		boolean test = current.isNull(front);
		System.out.println(test);
		while (current != null) {//not at the end, prevents out of bounds
		String PlayerName = current.getPlayer().getName();
		s += PlayerName + " ";
		current = current.getNext();
		}
		return s;
		}

		public static void main(String [] args) {
			WaitList WL = new WaitList();
			BadmintonPlayer J = new BadmintonPlayer("Jimmy");
			BadmintonPlayer H = new BadmintonPlayer("Hern");
			BadmintonPlayer G = new BadmintonPlayer("Gennie");
			WL.enqueue(J);
			WL.enqueue(H);
			//WL.enqueue(G);
			System.out.println(WL.toString());
			//System.out.println("First in Line: " + RQ.peek().getName());
			
		}
	}

