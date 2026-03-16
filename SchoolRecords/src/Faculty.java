import java.time.LocalDate;

/**
 * Faculty class represents a faculty member with office hours and rank.
 */
public class Faculty extends Employee {

    private String officeHours; // string format like "9am-5pm"
    private String rank;        // junior, senior

    public Faculty(String name, String address, String phoneNumber, String email,
                   String office, double salary, LocalDate dateHired,
                   String officeHours, String rank) {
        super(name, address, phoneNumber, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() { return officeHours; }
    public void setOfficeHours(String officeHours) { this.officeHours = officeHours; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    @Override
    public String toString() {
        return super.toString() +
               "\nOffice Hours: " + officeHours +
               "\nRank: " + rank;
    }
}