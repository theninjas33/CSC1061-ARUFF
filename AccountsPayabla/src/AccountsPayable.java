import java.util.Scanner; // imports the Scanner class so we can read input from the keyboard

public class AccountsPayable { // main class for the program

    // Method that prints an Employee object using its toString() method
    public static void printEmployee(Employee emp) {
        System.out.println(emp.toString()); // calls the object's toString method automatically
    }

    // Method that prints employee information WITHOUT using toString()
    // Instead it calls each getter method individually
    public static void printEmployeeWithoutToString(Employee emp) {
        System.out.println("First Name: " + emp.getFirstName()); // get first name
        System.out.println("Last Name: " + emp.getLastName()); // get last name
        System.out.println("SSN: " + emp.getSocialSecurityNumber()); // get SSN
        System.out.println("Payment Amount: " + emp.getPaymentAmount()); // polymorphic call to calculate payment
    }

    // Main method where the program starts running
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creates Scanner object to read user input
        Employee[] payableEmployees = new Employee[6]; // creates an array that can store 6 Employee objects

        // loop that runs 6 times to create 6 employees
        for (int i = 0; i < payableEmployees.length; i++) {

            // ask the user what type of employee they want to create
            System.out.println("\nEnter employee type:");
            System.out.println("1 - Salaried");
            System.out.println("2 - Commission");
            System.out.println("3 - Hourly");
            System.out.println("4 - Base Plus Commission");

            int type = input.nextInt(); // read employee type
            input.nextLine(); // consume leftover newline so nextLine works properly

            // collect common employee information
            System.out.print("First Name: ");
            String first = input.nextLine(); // read first name

            System.out.print("Last Name: ");
            String last = input.nextLine(); // read last name

            System.out.print("SSN: ");
            String ssn = input.nextLine(); // read SSN

            // if employee is salaried
            if (type == 1) {

                System.out.print("Weekly Salary: ");
                double salary = input.nextDouble(); // read weekly salary

                // create SalariedEmployee object and store it in the array
                payableEmployees[i] =
                        new SalariedEmployee(first, last, ssn, salary);

            } 
            
            // if employee is commission-based
            else if (type == 2) {

                System.out.print("Gross Sales: ");
                double sales = input.nextDouble(); // read total sales

                System.out.print("Commission Rate: ");
                double rate = input.nextDouble(); // read commission percentage

                // create CommissionEmployee object
                payableEmployees[i] =
                        new CommissionEmployee(first, last, ssn, sales, rate);

            } 
            
            // if employee is hourly
            else if (type == 3) {

                System.out.print("Hourly Wage: ");
                double wage = input.nextDouble(); // read hourly wage

                System.out.print("Hours Worked: ");
                double hours = input.nextDouble(); // read hours worked

                // create HourlyEmployee object
                payableEmployees[i] =
                        new HourlyEmployee(first, last, ssn, wage, hours);

            } 
            
            // otherwise it must be BasePlusCommission employee
            else {

                System.out.print("Gross Sales: ");
                double sales = input.nextDouble(); // read sales amount

                System.out.print("Commission Rate: ");
                double rate = input.nextDouble(); // read commission rate

                System.out.print("Base Salary: ");
                double base = input.nextDouble(); // read base salary

                // create BasePlusCommissionEmployee object
                payableEmployees[i] =
                        new BasePlusCommissionEmployee(first, last, ssn, sales, rate, base);
            }
        }

        // print payments for all employees
        System.out.println("\nEmployee Payments:");

        // enhanced for-loop that goes through each Employee in the array
        for (Employee emp : payableEmployees) {

            System.out.println(emp.getFirstName() + " " + emp.getLastName()); // print employee name
            System.out.println("Payment: " + emp.getPaymentAmount()); // polymorphism: correct payment method is called
        }

        // second loop used to find BasePlusCommission employees
        for (Employee emp : payableEmployees) {

            // check if the current employee is a BasePlusCommissionEmployee
            if (emp instanceof BasePlusCommissionEmployee) {

                // cast Employee reference into BasePlusCommissionEmployee
                BasePlusCommissionEmployee baseEmp =
                        (BasePlusCommissionEmployee) emp;

                // increase base salary by 10%
                baseEmp.setBaseSalary(baseEmp.getBaseSalary() * 1.10);
            }
        }

        // print payments again after salary increase
        System.out.println("\nAfter 10% Base Salary Increase:");

        for (Employee emp : payableEmployees) {

            System.out.println(emp.getFirstName() + " " + emp.getLastName()); // print employee name
            System.out.println("Payment: " + emp.getPaymentAmount()); // show updated payment
        }

        input.close(); // close scanner to free system resources
    }
}