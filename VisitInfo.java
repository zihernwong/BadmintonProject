
public class VisitInfo {
    
    // The court number of the patient.
    public int courtNum;
    // The reason the patient came to the hospital.
    public String notes;
    
    /**
     * Puts the visit information into a string.
     * @return - A string representing the visit information.
     */
    public String toString() {
        String info = "";
        
        if(courtNum != 0) {
            info += "Court Number: " + Integer.toString(courtNum) + "\n";
        }
        
        if(notes != null) {
            info += "Notes: " + notes + "\n";
        }        
        return info;
    }
    
    /**
     *  Constructor that creates no visit info based off of receiving no parameters.
     */
    public VisitInfo() {}
    
    /**
     * Constructor that creates visit info based off of parameters.
     * @param roomNum - The room number of the patient.
     * @param reason - Reason the patient visited.
     */
    public VisitInfo(int roomNum, String reason) {
        this.roomNum = roomNum;
        this.reason = reason;
    }
    
    /**
     * Constructor that creates visit info based off of parameters.
     * @param roomNum - The room number of the patient.
     * @param reason - Reason the patient visited.
     * @param notes - Notes from the doctor about visit.
     * @param treatment - Treatment prescribed by doctor.
     */
    public VisitInfo(int roomNum, String reason, String notes, String treatment) {
        this.roomNum = roomNum;
        this.reason = reason;
        this.notes = notes;
        this.treatment = treatment;
    }
    
    /**
     * Sets the notes for the visit info to whatever was passed.
     * @param notes - The notes from the doctor about this visit.
     */
    public void setNotes(String notes) {
            this.notes = notes;
    }
  
    /**
     * Sets the treatment for the visit info to whatever was passed.
     * @param treatment - The treatment prescribed by the doctor.
     */
    public void setTreatment(String treatment) {
            this.treatment = treatment;
    }
}