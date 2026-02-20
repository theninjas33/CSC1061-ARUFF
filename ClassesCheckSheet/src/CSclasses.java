import java.util.ArrayList;
import java.util.Scanner;

// Driver class
public class CSclasses {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Course> courseList = new ArrayList<>();

     
        courseList.add(createInPersonCourse(input));
        courseList.add(createFullRemoteCourse(input));
        courseList.add(createRealTimeRemoteCourse(input));

        System.out.println("\n- COURSE DETAILS -\n");

       
        for (Course c : courseList) {
            printCourseDetails(c);
            System.out.println();
        }

        input.close();
    }

 
    public static void printCourseDetails(Course course) {
        System.out.println(course.toString());
    }

 

    private static Course createInPersonCourse(Scanner input) {
        System.out.println("Enter In-Person Course Info");
        System.out.print("Course Number: ");
        String number = input.nextLine();

        System.out.print("Students Enrolled: ");
        int students = input.nextInt();

        System.out.print("Max Students: ");
        int max = input.nextInt();

        System.out.print("Credits: ");
        int credits = input.nextInt();
        input.nextLine(); // clear buffer

        System.out.print("Room Number: ");
        String room = input.nextLine();

        return new InPersonCourse(number, students, max, credits, room);
    }

    private static Course createFullRemoteCourse(Scanner input) {
        System.out.println("\nEnter Full Remote Course Info");
        System.out.print("Course Number: ");
        String number = input.nextLine();

        System.out.print("Students Enrolled: ");
        int students = input.nextInt();

        System.out.print("Max Students: ");
        int max = input.nextInt();

        System.out.print("Credits: ");
        int credits = input.nextInt();
        input.nextLine();

        System.out.print("Contact Email: ");
        String email = input.nextLine();

        return new FullRemoteCourse(number, students, max, credits, email);
    }

    private static Course createRealTimeRemoteCourse(Scanner input) {
        System.out.println("\nEnter Real-Time Remote Course Info");
        System.out.print("Course Number: ");
        String number = input.nextLine();

        System.out.print("Students Enrolled: ");
        int students = input.nextInt();

        System.out.print("Max Students: ");
        int max = input.nextInt();

        System.out.print("Credits: ");
        int credits = input.nextInt();
        input.nextLine();

        System.out.print("Zoom Info: ");
        String zoom = input.nextLine();

        return new RealTimeRemoteCourse(number, students, max, credits, zoom);
    }
}
