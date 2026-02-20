
public class vheicle implemeents feedable{
	
	private String color;
	private int id;

	
	
	//getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setColor(String color) {
		this.color = color;
	
	}
	public abstract String drive();
	@Override
	public String toString() {
		return "vheicle [color=" + color + ", id=" + id + "]";
	}
	
	
}
