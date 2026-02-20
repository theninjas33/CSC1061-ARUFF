import java.util.Date;

public class GeometricObject {

	//Data Members
	private String color = "white";
	private boolean isFilled = false;
	private Date dateCreated;
	
	//Constructors
	public GeometricObject(String color, boolean isFilled) {
		this.color = color;
		this.isFilled = isFilled;
		dateCreated = new Date();
	}
	//getters and setters
	
	
	public GeometricObject() {
		
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", isFilled=" + isFilled + ", dateCreated=" + dateCreated + "]";
	}



}
