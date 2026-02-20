// Traditional in-person course
public class InPersonCourse extends Course {

    private String roomNumber;

    public InPersonCourse(String cNumber, int students, int max, int creds, String room) {
        super(cNumber, students, max, creds);
        roomNumber = room;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDelivery: In-Person"
                + "\nRoom: " + roomNumber;
    }
}
