
public class Courts {
private boolean used;
private BadmintonGroup group;
private String courtName;
	public Courts() {
		this.used = false;
		this.group = null;
	}
	
	public void setStatus(boolean status) {
		this.used = status;
	}
	public boolean getStatus() {
		return this.used;
	}
	public void setCourtName(String name) {
		this.courtName = name;
	}
	
}
