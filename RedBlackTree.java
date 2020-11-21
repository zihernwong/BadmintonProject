
import java.util.LinkedList;


/**
 * Binary Search Tree implementation with a Node inner class for representing
 * the nodes within a binary search tree.  You can use this class' insert
 * method to build a binary search tree, and its toString method to display
 * the level order (breadth first) traversal of values in that tree.
 */
public class RedBlackTree<T extends Comparable<T>> {
	public Node<T> lastInserted;
    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always be maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild; 
        public Node<T> rightChild; 
        public boolean isBlack;
        
        public Node(T data) { this.data = data; this.isBlack=false;}
        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }
        /**
         * This method performs a level order traversal of the tree rooted
         * at the current node.  The string representations of each data value
         * within this tree are assembled into a comma separated string within
         * brackets (similar to many implementations of java.util.Collection).
         * @return string containing the values of this tree in level order
         */
        @Override
        public String toString() { // display subtree in order traversal
            String output = "[";
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.leftChild != null) q.add(next.leftChild);
                if(next.rightChild != null) q.add(next.rightChild);
                output += next.data.toString();
                if(!q.isEmpty()) output += ", ";
            }
            return output + "]";
        }
    }

    protected Node<T> root; // reference to root node of tree, null when empty

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree.  After  
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * @param data to be added into this binary search tree
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when the tree already contains data
     */
    public void insert(T data) throws NullPointerException,
				      IllegalArgumentException {
        // null references cannot be stored within this tree
        if(data == null) throw new NullPointerException(
            "This RedBlackTree cannot store null references.");
        
        Node<T> newNode = new Node<>(data);
        if(root == null) { root = newNode; } // add first node to an empty tree
        else insertHelper(newNode,root); // recursively insert into subtree
        root.isBlack=true;
    }

    /** 
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the 
     *      newNode should be inserted as a descenedent beneath
     * @throws IllegalArgumentException when the newNode and subtree contain
     *      equal data references (as defined by Comparable.compareTo())
     */
    private void insertHelper(Node<T> newNode, Node<T> subtree) {
        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if(compare == 0) throw new IllegalArgumentException(
            "This RedBlackTree already contains that value.");

        // store newNode within left subtree of subtree
        else if(compare < 0) {
            if(subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
            // otherwise continue recursive search for location to insert
            } else insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else { 
            if(subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
            // otherwise continue recursive search for location to insert
            } else insertHelper(newNode, subtree.rightChild);
        }
    }

    /**
     * This method performs a level order traversal of the tree. The string 
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations 
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * @return string containing the values of this tree in level order
     */
    @Override
    public String toString() { return root.toString(); }


    /**
     * This method enforces the order rules of Red Black Tree and is called upon after the 
     * insert method. This method breaks up into 3 cases and keeps looping until child's parent
     * is not null and child's parent is black
     * case 1: leaf is red, parent and parent sibling are red
     * do for case 1: first change both parent and parent siblings to black, then get
     * that parent and see if it is the opposite color until you hit root
     * case 2: leaf is red, parent is red, and parent's sibling is black/null. 
     * The parent's sibling has to be on opposite sides of the problematic node. so if the parent's sibling
     * is the left sibling, the problematic leaf must be the right child of the parent/right sibling
     * case 2 do: rotate (parent and grandparent) the recolor the granddparent of the 
     * troubling node to red and the parent of troubling node to black
     * case 3: is if the problematic node's parent is also red, and the parent's sibling is black.
     *  This is also only true if the parent's sibling is the same side as the problematic
    	node. E.g The Parent's sibling is the right child (the parent is the left child of the grandparent).
       The problematic node is the right child of the parent which warrants case 3
       case 3 do: rotate left child and parent

     * @param lastInserted 
     */
    private void enforceRBTreePropertiesAfterInsert(Node<T> node) {
    	
        if (node == root || node.parent == root || node.parent.isBlack)
        	{
        	return;
        	}
        Node<T> sib;
        Node<T> grand = node.parent.parent;
        Node<T> par = node.parent;
        if (par.isLeftChild()) {
        	sib = grand.rightChild;
        }
        else {sib = grand.leftChild;
        
        }
        if (sib == null || sib.isBlack) {
            if (par.isLeftChild()) {
                if (!node.isLeftChild()) {
                    rotate(node, par);
                    Node<T> temp = node;
                    node = par;
                    par = temp;
                }
                rotate(par, grand);
                par.isBlack = true;
                grand.isBlack = false;
            }
            else {
                if (node.isLeftChild()) {
                    rotate(node, par);
                    Node<T> temp = node;
                    node= par;
                    par = temp;
                }
                rotate(par, grand);
                par.isBlack = true;
                grand.isBlack = false;
            }
        }
        else {
            grand.isBlack = false;
            par.isBlack = true;
            sib.isBlack = true;
            enforceRBTreePropertiesAfterInsert(grand);
        }
    }
    /**
     * Performs the rotation operation on the provided nodes within this BST.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation (sometimes called a left-right 
     * rotation).  When the provided child is a rightChild of the provided 
     * parent, this method will perform a left rotation (sometimes called a 
     * right-left rotation).  When the provided nodes are not related in one 
     * of these ways, this method will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent)
	throws IllegalArgumentException {
        if (parent != null && child != null && (child.parent != parent) && (parent.leftChild != child && parent.rightChild != child)) 
            throw new IllegalArgumentException("no relationship");
        if(parent!=null) {
    		if(parent.leftChild!=null) {
	    if(parent.leftChild.equals(child)) {
    	if(!parent.equals(root)) {
    		if(parent.isLeftChild()) {
    			parent.parent.leftChild=child;
    		}
    		if(!parent.isLeftChild()) {
    			parent.parent.rightChild=child;
    		}
    	}
    	Node<T> temp = child.rightChild;//R
    	child.rightChild= parent;
    	child.parent = parent.parent; 
    	if(child.parent==null) {
    		root=child;
    	}
    	
    	parent.leftChild=temp;
    	if(temp!=null) {
    	parent.leftChild.parent=parent;
    	}
    }
    else if(parent.rightChild.equals(child)) {
    	Node<T> LC = child.leftChild;
	Node<T> G = parent.parent;
	if(G==null){
	    root = child;
	    child.leftChild=parent;
	    parent.rightChild = LC;
	}
	else{
	    if(G.leftChild.equals(parent)){
		    G.leftChild = child;
		    child.leftChild = parent;
		    parent.rightChild = LC;
		}
	    else if(G.rightChild.equals(parent)){
			G.rightChild = child;
			child.leftChild = parent;
			parent.rightChild = LC;
		    }
		    }
	
	}
    		}
        }
    }
}


    



