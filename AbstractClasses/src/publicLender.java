
public class publicLender extends FancualInstitution{

	public publicLender(String name) {
		super(name);
	}
	@Override
	public double getIntrestRate() throws UnsupportedOperationException {
		throw new UnsupportedOpperationException("This bank does not lend")
	}

}
