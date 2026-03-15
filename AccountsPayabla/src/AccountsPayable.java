import java.util.Scanner;

public class AccountsPayable {

    public static void printEmployee(Employee emp) {
        System.out.println(emp.toString());
    }

    public static void printEmployeeWithoutToString(Employee emp) {
        System.out.println("First Name: " + emp.getFirstName());
        System.out.println("Last Name: " + emp.getLastName());
        System.out.println("SSN: " + emp.getSocialSecurityNumber());
        System.out.println("Payment Amount: " + emp.getPaymentAmount());
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Employee[] payableEmployees = new Employee[6];

        for (int i = 0; i < payableEmployees.length; i++) {

            System.out.println("\nEnter employee type:");
            System.out.println("1 - Salaried");
            System.out.println("2 - Commission");
            System.out.println("3 - Hourly");
            System.out.println("4 - Base Plus Commission");

            int type = input.nextInt();
            input.nextLine();

            System.out.print("First Name: ");
            String first = input.nextLine();

            System.out.print("Last Name: ");
            String last = input.nextLine();

            System.out.print("SSN: ");
            String ssn = input.nextLine();

            if (type == 1) {

                System.out.print("Weekly Salary: ");
                double salary = input.nextDouble();

                payableEmployees[i] =
                        new SalariedEmployee(first, last, ssn, salary);

            } else if (type == 2) {

                System.out.print("Gross Sales: ");
                double sales = input.nextDouble();

                System.out.print("Commission Rate: ");
                double rate = input.nextDouble();

                payableEmployees[i] =
                        new CommissionEmployee(first, last, ssn, sales, rate);

            } else if (type == 3) {

                System.out.print("Hourly Wage: ");
                double wage = input.nextDouble();

                System.out.print("Hours Worked: ");
                double hours = input.nextDouble();

                payableEmployees[i] =
                        new HourlyEmployee(first, last, ssn, wage, hours);

            } else {

                System.out.print("Gross Sales: ");
                double sales = input.nextDouble();

                System.out.print("Commission Rate: ");
                double rate = input.nextDouble();

                System.out.print("Base Salary: ");
                double base = input.nextDouble();

                payableEmployees[i] =
                        new BasePlusCommissionEmployee(first, last, ssn, sales, rate, base);
            }
        }

        System.out.println("\nEmployee Payments:");

        for (Employee emp : payableEmployees) {

            System.out.println(emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Payment: " + emp.getPaymentAmount());
        }

        for (Employee emp : payableEmployees) {

            if (emp instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee baseEmp =
                        (BasePlusCommissionEmployee) emp;

                baseEmp.setBaseSalary(baseEmp.getBaseSalary() * 1.10);
            }
        }

        System.out.println("\nAfter 10% Base Salary Increase:");

        for (Employee emp : payableEmployees) {

            System.out.println(emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Payment: " + emp.getPaymentAmount());
        }

        input.close();
    }
}