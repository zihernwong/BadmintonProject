
public class WLNode {

		  private BadmintonPlayer player;
		  private WLNode next;

		  /**
		 * @param group
		 */
		public WLNode(BadmintonPlayer player) {
			this.player = player;
		    this.next = null;
		  }

		  /**
		 * @param group
		 * @param next
		 */
		public WLNode (BadmintonPlayer player, WLNode next) {
		    this.player = player;
		    this.next = next;
		  }
		public boolean isNull (WLNode para) {
			if(para==null) {
				return true;
			}
			else return false;
		}
		
		  public BadmintonPlayer getPlayer() {//accessor method
		    return this.player;
		  }

		  public WLNode getNext() {//accessor method
		    return this.next;
		  }

		  public void setNext(WLNode next) {//mutator method
		    this.next = next;
		  }

		

}
