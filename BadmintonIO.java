import java.io.*;
import java.util.ArrayList;


public class BadmintonIO {
    // The ArrayList of patients from the given file.
    public ArrayList<BadmintonPlayer> players;
    // The name of the file we are reading the patients from.
    public String fileName;
    
    /**
     * A constructor which creates the ArrayList of patients and attempts
     * to load it with the given file.
     * @param fileName -  The name of the file being read.
     */
    public BadmintonIO(String fileName) {
        this.fileName = fileName;
        
        try {
            this.loadPlayers(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * A constructor which creates the ArrayList of patients and attempts
     * to load it with the given file.
     * @param fileName - The name of the file being read.
     * @param patients - The ArrayList of patients at the hospital.
     */
    public BadmintonIO(String fileName, ArrayList<BadmintonPlayer> players) {
        this.fileName = fileName;
        this.players = players;
    }
    
    /**
     * Reads the file of patients to a given list of patients.
     * @param fileName -  The name of the file being read.
     * @throws IOException - If the file does not match the format of other patient information.
     */
    public void loadPlayers(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String str;
        
        while((str = br.readLine()) != null) {
            String[] arr = str.split(",");
            
            for(int i=0; i<arr.length; i++) {
                arr[i] = arr[i].trim();
            }
            BadmintonPlayer player = new BadmintonPlayer (arr[0], arr[1], arr[2]);
            this.players.add(player);
            
        }
        br.close();
    }
    
    /**
     * Creates a writer which writes out all of a patient's information in the correct order.
     * @param fileName - The name of the given file.
     * @throws IOException - If the file does not match the format of other patient information.
     */
    public void writePlayers(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        for(int i=0; i<this.players.size(); i++) {
            printWriter.print(this.players.get(i) + "\n");
        }
        printWriter.close();
    }
    
    /**
     * Gets and returns the list of patients at the hospital.
     * @return getList - A list of patients at the hospital.
     */
    public ArrayList<BadmintonPlayer> getList(){
        return this.players;
    }
    
}