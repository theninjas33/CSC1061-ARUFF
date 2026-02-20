// Parent class for online courses
public class OnlineCourse extends Course {

    public OnlineCourse(String cNumber, int students, int max, int creds) {
		super(cNumber, students, max, creds);
	}

	@Override
    public String toString() {
        return super.toString() + "\nCourse Type: Online";
    }
}
