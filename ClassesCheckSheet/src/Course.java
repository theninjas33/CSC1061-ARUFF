// Project: ClassesCheckSheet


// Base class for all courses
public class Course {

    protected String courseNumber;
    protected int numStudents;
    protected int maxStudents;
    protected int credits;

 
    public Course(String cNumber) {
        courseNumber = cNumber;
        numStudents = 20;
        maxStudents = 30;
        credits = 4;
    }

   
    public Course(String cNumber, int students, int max, int creds) {
        courseNumber = cNumber;
        numStudents = students;
        maxStudents = max;
        credits = creds;
    }

   
    @Override
    public String toString() {
        return "Course Number: " + courseNumber + "\n"
             + "Students Enrolled: " + numStudents + "\n"
             + "Max Students: " + maxStudents + "\n"
             + "Credits: " + credits;
    }
}
