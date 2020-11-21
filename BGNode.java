/**
 * @author wongz
 *Allows it a BoardingGroup to have a "next"
 *Has various accessor and mutator methods to use the private data
 *
 */
public class BGNode {

  private BadmintonGroup group;
  private BGNode next;

  /**
 * @param group
 */
public BGNode(BadmintonGroup group) {
    this.group = group;
    this.next = null;
  }

  /**
 * @param group
 * @param next
 */
public BGNode(BadmintonGroup group, BGNode next) {
    this.group = group;
    this.next = next;
  }

  public BadmintonGroup getGroup() {//accessor method
    return group;
  }

  public BGNode getNext() {//accessor method
    return next;
  }

  public void setNext(BGNode next) {//mutator method
    this.next = next;
  }

}
