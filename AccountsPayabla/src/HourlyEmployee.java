public class HourlyEmployee extends Employee {
    // HourlyEmployee is a subclass of Employee.
    // It represents employees paid based on hours worked.

    private double hourlyWage; // stores the amount earned per hour
    private double hours;      // stores the total hours worked

    // Constructor to initialize HourlyEmployee
    public HourlyEmployee(String firstName, String lastName, String ssn,
                          double hourlyWage, double hours) {

        super(firstName, lastName, ssn); 
        // calls the constructor of Employee to set first name, last name, and SSN
        this.hourlyWage = hourlyWage; 
        // initialize hourly wage
        this.hours = hours; 
        // initialize hours worked
    }

    // Getter for hourlyWage
    public double getHourlyWage() {
        return hourlyWage; // return the hourly wage
    }

    // Setter for hourlyWage
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage; // update the hourly wage
    }

    // Getter for hours
    public double getHours() {
        return hours; // return hours worked
    }

    // Setter for hours
    public void setHours(double hours) {
        this.hours = hours; // update hours worked
    }

    @Override
    public double getPaymentAmount() {
        // Calculates payment for the employee
        // Payment = hourly wage * hours worked
        return hourlyWage * hours; 
    }

    @Override
    public String toString() {
        // Returns a string representation of HourlyEmployee
        return super.toString() + // include Employee info (name, SSN)
               "\nHourly Wage: " + hourlyWage + // add hourly wage info
               "\nHours: " + hours + // add hours worked info
               "\nPayment Amount: " + getPaymentAmount(); // add calculated payment
    }
}