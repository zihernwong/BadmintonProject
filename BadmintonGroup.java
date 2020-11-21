
/**
 * @author wongz
 *This class creates an Object called BoardingGroup used in RideQueue and BGNode
 *It contains accessors and a mutator
 */
public class BadmintonGroup {
private int numPeople;
private String groupName;
//constructor
/**
 * @param name
 * @param numPeo
 */
public BadmintonGroup() {
	this.numPeople = 0;
	this.groupName = "";
}
public BadmintonGroup(BadmintonPlayer BP1) {//one player constructor
	this.numPeople = 1;
	String temp = "";
	temp+= toString(BP1);
	this.groupName = temp;
}
public BadmintonGroup(BadmintonPlayer BP1, BadmintonPlayer BP2) {//two player constructor
	this.numPeople = 2;
	BadmintonPlayer arry [] = new BadmintonPlayer[2];
		arry[0] = BP1;
		arry[1] = BP2;
	
	String temp = "";
	for(int i =0;i<this.numPeople;i++) {
		temp+= toString(arry[i]);
	}
	this.groupName = temp;
}
public BadmintonGroup(BadmintonPlayer BP1, BadmintonPlayer BP2, BadmintonPlayer BP3) {//three player constructor
	this.numPeople = 3;
	BadmintonPlayer arry [] = new BadmintonPlayer[3];
	arry[0] = BP1;
	arry[1] = BP2;
	arry[2] = BP3;

String temp = "";
for(int i =0;i<this.numPeople;i++) {
	temp+= toString(arry[i]);
}
this.groupName = temp;
}
public BadmintonGroup(BadmintonPlayer BP1, BadmintonPlayer BP2, BadmintonPlayer BP3, BadmintonPlayer BP4) {//four player constructor
	this.numPeople = 4;
	BadmintonPlayer arry [] = new BadmintonPlayer[4];
	arry[0] = BP1;
	arry[1] = BP2;
	arry[2] = BP3;
	arry[3] = BP4;

String temp = "";
for(int i =0;i<this.numPeople;i++) {
	temp+= toString(arry[i]);
}
this.groupName = temp;
}
/**
 * @return String Name
 */
public String getName() {
	return groupName;
}
public String toString(BadmintonPlayer BP) {
	return "" + BP.getName() +" ";
	
}
public void setName(String setter) {
	this.groupName = setter;
}

/**
 * @return int numPeople
 */
public int getNumPeople() {
	return numPeople;
}

public static void main(String [] args) {
//	BadmintonPlayer BO = new BadmintonPlayer("hern");
//	BadmintonGroup test = new BadmintonGroup(BO);
//	System.out.println(test.groupName);
}
}
