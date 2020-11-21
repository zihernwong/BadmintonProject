//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//
// Title: (P08 Badger Coaster)
// Files: (sample.txt. QueueADT.java, RideQueue.java, ThemeParkApp.java, 
//			BGNode.java, BoardingGroup.java)
// Course: (CS300, Spring, 2020)
//
// Author: (Zi Hern Wong)
// Email: (zwong4@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//                    NONE
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//https://en.wikipedia.org/wiki/Zeller%27s_congruence#Implementation_in_software
//
///////////////////////////////////////////////////////////////////////////////
/**
 * @author wongz
 *An interface that allows us to a backbone to implement these methods
 * @param <BoardingGroup>
 */
public interface QueueADT <BoardingGroup> {
	
	public boolean isEmpty();
	
	public void	enqueue(BoardingGroup newObject);
	
	public void clear();
	
	public BoardingGroup peek();
	
	public BoardingGroup dequeue();
}