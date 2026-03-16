import java.time.LocalDate;
/**
 * Staff class represents a staff member with a title.
 */
public class Staff extends Employee {

    private String title;

    public Staff(String name, String address, String phoneNumber, String email,
                 String office, double salary, LocalDate dateHired,
                 String title) {
        super(name, address, phoneNumber, email, office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return super.toString() +
               "\nTitle: " + title;
    }
}