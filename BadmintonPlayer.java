
public class BadmintonPlayer implements Comparable <BadmintonPlayer> {

		private String name;
		 private boolean registerStatus;
		 private int playerID;
		 
		//constructor
		/**
		 * @param name
		 * @param numPeo
		 */
		public BadmintonPlayer(String name) {
			this.name = name;
			this.registerStatus = false;
		}
		//if from file
		public BadmintonPlayer(String id, String name, String registered) {
			this.playerID = Integer.parseInt(id);
			this.name = name;
			if(registered.contains("un")) {
				this.registerStatus = false;
			}
			else {
				this.registerStatus = true;
			}
		}

		/**
		 * @return String Name
		 */
		public String getName() {
			return name;
		}
		
	    /**
	     * Gets and returns a given patient's ID.
	     * @return - patient's ID
	     */
	    public int getId() {
	        return playerID;
	    }
	    
	    /**
	     * Sets whether a patient is in the hospital currently or not.
	     * @param status - whether a patient is in the hospital or not.
	     */
	    public void setStatus(boolean status) {
	        this.registerStatus = status;
	    }

	    
	    /**
	     * Put's the patient's info into a string and returns it.
	     * @returns - A string representation of the patient
	     */
	    public String toString() {
	        String info = "Name: " + this.name + ", ";
	        info += "ID: " + this.playerID + ", ";
	        info += "Registered: " + (this.registerStatus ? "Checked In" : "Checked Out") + "\n";
	        return info;
	    }
	    
	    /**
	     * Compares two patients based on their IDs.
	     * @returns - 1 if patientID is larger, -1 if patientID is smaller, O if they
	     * are equal.
	     */
	    public int compareTo(BadmintonPlayer p) {
	        if(this.playerID > p.playerID) {
	            return 1;
	        }
	        if(this.playerID < p.playerID) {
	            return -1;
	        }
	        return 0;
	    }



		}


