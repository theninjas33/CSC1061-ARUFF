public class SalariedEmployee extends Employee {
    // SalariedEmployee is a subclass of Employee.
    // It represents employees who earn a fixed weekly salary.

    private double weeklySalary; // stores the fixed weekly salary

    // Constructor to initialize SalariedEmployee
    public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
        super(firstName, lastName, ssn); 
        // calls the constructor of Employee to set first name, last name, and SSN
        this.weeklySalary = weeklySalary; 
        // initialize weekly salary
    }

    // Getter for weeklySalary
    public double getWeeklySalary() {
        return weeklySalary; // return the weekly salary
    }

    // Setter for weeklySalary
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary; // update the weekly salary
    }

    @Override
    public double getPaymentAmount() {
        // Calculates payment for the employee
        // Payment = fixed weekly salary
        return weeklySalary; 
    }

    @Override
    public String toString() {
        // Returns a string representation of SalariedEmployee
        return super.toString() + // include Employee info (name, SSN)
               "\nWeekly Salary: " + weeklySalary + // add weekly salary info
               "\nPayment Amount: " + getPaymentAmount(); // add calculated payment
    }
}