

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BackEndHoL {

  private RedBlackTree<BadmintonPlayer> BadmintonPlayerTree;
  private ArrayList<BadmintonPlayer> BadmintonPlayerData;
  private String fileName;

  /**
   * Constructor
   */
  public BackEndHoL() {
    BadmintonPlayerTree = new RedBlackTree<BadmintonPlayer>();    
    fileName = "PatientData.txt";
    BadmintonIO loader = new BadmintonIO(fileName);
    BadmintonPlayerData = loader.getList();
    for (int i = 0; i < BadmintonPlayerData.size(); i++) {
      BadmintonPlayerTree.insert(BadmintonPlayerData.get(i));
    }
  }
  
  /**
   * This method adds a patient to the red black tree. First it randomly
   * generates a 6 digit number, and if the number is already taken by a
   * patient it will call itself and randomly generate another number.
   * It then creates the new patient object and inserts it into the tree
   * @param name
   * @param dateOfBirth
   * @param reason
   * @return the toString() output of the new patient
   */
  public String addPlayer(String name) {
    int newId = (int) (Math.random() * ((1000000 - 100000 + 1) + 100000));
    if (lookupHelper(BadmintonPlayerTree.root, newId) == null) {
      BadmintonPlayer newBadmintonPlayer = new BadmintonPlayer (name);
      //newPatient.addVisit(roomNum, reason);
      BadmintonPlayerData.add(newBadmintonPlayer);
      BadmintonPlayerTree.insert(newBadmintonPlayer);
      return newBadmintonPlayer.toString();
    } else {
      addPlayer(name);//recursion
    }
    return "";
  }
  
  /**
   * This method calls the lookup helper to find a patient in the red black tree
   * from a given id number.
   * @param patientId
   * @return the toString of the patient object found
   */
  public String lookup(int playerId) {
    BadmintonPlayer target = lookupHelper(BadmintonPlayerTree.root, playerId);
    if (target == null) {
      return "Player Not Found";
    } else {
      return target.toString();
    }
  }
  
  /**
   * This method traverses the red black tree recursively inorder to find a
   * matching ID number.
   * @param root
   * @param patientId
   * @return null if the number is not found, else it returns the Patient object
   */
  private BadmintonPlayer lookupHelper(RedBlackTree.Node<BadmintonPlayer> root, int playerId) {
    if (root == null) {
      return null;
    }
    if (root.data.getId() == playerId) {
      return root.data;
    }

    BadmintonPlayer recurseLeft = lookupHelper(root.leftChild, playerId);
    BadmintonPlayer recurseRight = lookupHelper(root.rightChild, playerId);
    if (recurseLeft != null) {
      return recurseLeft;
    }
    if (recurseRight != null) {
      return recurseRight;
    }
    return null;
  }

  /**
   * This method creates a new txt file of the database with the changes made
   * using the application.
   * @param newName
   */
  public void writeFile(String newName) {
    newName += ".txt";
    BadmintonIO overwriteFile = new BadmintonIO(newName, BadmintonPlayerData);
    try {
    overwriteFile.writePlayers(newName);

    } catch (IOException e) {
      System.out.println("Error. File could not be saved.");
    }
  }
}