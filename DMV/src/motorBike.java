
public abstract interface motorBike extends vheicle {

	public motorBike(String name) {
		super(name);
	}
	@Override
	public abstract drive() {
		return "Braaaap";
}
