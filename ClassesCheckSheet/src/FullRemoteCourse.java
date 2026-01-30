// Fully asynchronous online course
public class FullRemoteCourse extends OnlineCourse {

    private String contactEmail;

    public FullRemoteCourse(String cNumber, int students, int max, int creds, String email) {
        super(cNumber, students, max, creds);
        contactEmail = email;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDelivery: Full Remote"
                + "\nContact Email: " + contactEmail;
    }
}
