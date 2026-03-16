public class CommissionEmployee extends Employee {
    // This class extends Employee, meaning it inherits firstName, lastName, and SSN fields
    // and related methods. CommissionEmployee adds its own fields and behavior for commission-based pay.

    private double grossSales; // total sales made by the employee
    private double commissionRate; // commission percentage (e.g., 0.10 for 10%)

    // Constructor to initialize CommissionEmployee
    public CommissionEmployee(String firstName, String lastName, String ssn,
                              double grossSales, double commissionRate) {

        super(firstName, lastName, ssn); 
        // call the parent (Employee) constructor to set first name, last name, and SSN
        this.grossSales = grossSales; // initialize gross sales
        this.commissionRate = commissionRate; // initialize commission rate
    }

    // Getter for grossSales
    public double getGrossSales() {
        return grossSales; // returns the total sales
    }

    // Setter for grossSales
    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales; // updates total sales
    }

    // Getter for commissionRate
    public double getCommissionRate() {
        return commissionRate; // returns the commission rate
    }

    // Setter for commissionRate
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate; // updates commission rate
    }

    @Override
    public double getPaymentAmount() {
        // calculates the payment for this employee
        // payment = grossSales * commissionRate
        return grossSales * commissionRate; 
    }

    @Override
    public String toString() {
        // creates a string representation of the employee
        return super.toString() + // include Employee info (first name, last name, SSN)
               "\nGross Sales: " + grossSales + // add gross sales info
               "\nCommission Rate: " + commissionRate + // add commission rate info
               "\nPayment Amount: " + getPaymentAmount(); // add total payment
    }
}