// Project: ClassesCheckSheet

/* =======================
   Driver Class
   ======================= */
public class CSclasses {

    public static void main(String[] args) {

        Course myCourse = new Course("CSC119");
        Course anotherCourse = new Course("CSC120", 18, 25, 3);

        System.out.println(myCourse);
        System.out.println();
        System.out.println(anotherCourse);
    }
}

/* =======================
   Course Class
   ======================= */
class Course {

    // data members (fields)
    private String courseNumber;
    private int numStudents;
    private int maxStudents;
    private int credits;

    // constructor 
    public Course(String cNumber) {
        courseNumber = cNumber;
        numStudents = 20;
        maxStudents = 30;
        credits = 4;
    }

    // constructor with all values
    public Course(String cNumber, int students, int max, int creds) {
        courseNumber = cNumber;
        numStudents = students;
        maxStudents = max;
        credits = creds;
    }

    // getters and setters
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    // toString method
    @Override
    public String toString() {
        return "Course Number: " + courseNumber + "\n"
             + "Number of Students: " + numStudents + "\n"
             + "Max Students: " + maxStudents + "\n"
             + "Credits: " + credits;
    }
}
