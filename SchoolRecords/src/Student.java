/**
 * Student class represents a student with a status (freshman, sophomore, etc.)
 */
public class Student extends Person {

    private String status; // freshman, sophomore, junior, senior

    public Student(String name, String address, String phoneNumber, String email, String status) {
        super(name, address, phoneNumber, email);
        this.status = status;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return super.toString() +
               "\nStatus: " + status;
    }
}