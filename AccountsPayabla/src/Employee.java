public abstract class Employee {
    // This is an abstract class, meaning you cannot create objects of Employee directly.
    // It serves as a base class for all types of employees.

    private String firstName; // stores the employee's first name
    private String lastName; // stores the employee's last name
    private String socialSecurityNumber; // stores the employee's SSN

    // Default constructor
    public Employee() {
        // does nothing; fields can be set later using setters
    }

    // Constructor that initializes first name, last name, and SSN
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName; // set first name
        this.lastName = lastName; // set last name
        this.socialSecurityNumber = socialSecurityNumber; // set SSN
    }

    // Abstract method: must be implemented by all subclasses
    // This allows polymorphism: different employee types calculate payment differently
    public abstract double getPaymentAmount();

    // Getter for firstName
    public String getFirstName() {
        return firstName; // return the first name
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName; // update the first name
    }

    // Getter for lastName
    public String getLastName() {
        return lastName; // return last name
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName; // update last name
    }

    // Getter for socialSecurityNumber
    public String getSocialSecurityNumber() {
        return socialSecurityNumber; // return SSN
    }

    // Setter for socialSecurityNumber
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber; // update SSN
    }

    @Override
    public String toString() {
        // returns a string representation of the employee
        return "First Name: " + firstName +
               "\nLast Name: " + lastName +
               "\nSSN: " + socialSecurityNumber;
    }
}