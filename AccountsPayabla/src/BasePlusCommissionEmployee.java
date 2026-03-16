public class BasePlusCommissionEmployee extends CommissionEmployee { 
    // This class extends CommissionEmployee, meaning it inherits all fields and methods
    // from CommissionEmployee, but also adds its own functionality (baseSalary)

    private double baseSalary; 
    // new field to store the base salary for this type of employee

    // Constructor for BasePlusCommissionEmployee
    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn,
                                       double grossSales, double commissionRate,
                                       double baseSalary) {

        super(firstName, lastName, ssn, grossSales, commissionRate); 
        // calls the constructor of the parent class CommissionEmployee to set first name, last name, SSN, sales, and commission
        this.baseSalary = baseSalary; 
        // initializes the new baseSalary field for this subclass
    }

    // Getter method for baseSalary
    public double getBaseSalary() {
        return baseSalary; // returns the current base salary
    }

    // Setter method for baseSalary
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary; // updates the base salary
    }

    @Override
    public double getPaymentAmount() {
        // Overrides the parent method to calculate total payment
        // total payment = base salary + commission
        return baseSalary + super.getPaymentAmount(); 
        // super.getPaymentAmount() calls the CommissionEmployee version
    }

    @Override
    public String toString() {
        // Overrides toString to show all relevant information
        return super.toString() + // include CommissionEmployee info
               "\nBase Salary: " + baseSalary + // add base salary
               "\nPayment Amount: " + getPaymentAmount(); // add total payment
    }
}