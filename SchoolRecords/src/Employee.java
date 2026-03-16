import java.time.LocalDate;

/**
 * Employee class represents an employee with office, salary, and hire date.
 */
public class Employee extends Person {

    private String office;
    private double salary;
    private LocalDate dateHired;

    public Employee(String name, String address, String phoneNumber, String email,
                    String office, double salary, LocalDate dateHired) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() { return office; }
    public void setOffice(String office) { this.office = office; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public LocalDate getDateHired() { return dateHired; }
    public void setDateHired(LocalDate dateHired) { this.dateHired = dateHired; }

    @Override
    public String toString() {
        return super.toString() +
               "\nOffice: " + office +
               "\nSalary: " + salary +
               "\nDate Hired: " + dateHired;
    }
}