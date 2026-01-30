
public class Car {
	
	// Data Members
	private String color;
	private double amountOfGas;
	private int mileage;
	private int grndClearance;
	
	// Constructors
	
	public Car(String rcolor) {
		color = rcolor;
		amountOfGas = 1.0;
		mileage = 5;
	
	}
	
	public Car() {
	
	}
	public Car(String color, double gas) {
		this.color = color;
		amountOfGas = gas;
		mileage = 0;
	}
	// Getters and Setters ( Accessors and Mutators)
	public String getColor() {
		return color;
	}
		public void setColor(String color) {
			this.color = color;
	}

		public double getAmountOfGas() {
			return amountOfGas;
		}

		public void setAmountOfGas(double amountOfGas) {
			this.amountOfGas = amountOfGas;
		}

		public int getMileage() {
			return mileage;
		}

		public int getGrndClearance() {
			return grndClearance;
		}

		public void setGrndClearance(int grndClearance) {
			this.grndClearance = grndClearance;
		}
		//Methods
		
		public void drive(int NumMiles) {
			for (int i = 0;i < numMiles; i++) {
				System.out.println("+");
				
			}
			mileage = mileage + numMiles;
			amountOfGas -= numMIles;
			System.out.println();
		}
		
		
		
		
		//toString()
		public String toString() {
			return "Car: Color: " + color + "\nAmount of Gas: " 
					+ amountOfGas + "\nMileage: " + mileage;
			
		}
}
		