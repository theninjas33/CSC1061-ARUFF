
public abstract class Bank extends FinancialInstitution {
	
	public Bank(String name) {
		super(name);
		
		
	}
	@Override
	public double getIntrestRate() {
		return 0.06;
	}
	public void setSavings();
}
