import java.time.LocalDate;
import java.util.ArrayList;

public class TestSchoolRecords {

    public static void main(String[] args) {

        Database db = new Database();

        // Create 6 persons: 2 students, 2 faculty, 2 staff
        Student s1 = new Student("Alice", "123 Main St", "555-1111", "alice@email.com", "freshman");
        Student s2 = new Student("Bob", "456 Oak Ave", "555-2222", "bob@email.com", "junior");

        Faculty f1 = new Faculty("Dr. Smith", "789 Pine St", "555-3333", "smith@email.com",
                                 "Room 101", 80000, LocalDate.of(2020,1,15),
                                 "9am-5pm", "senior");
        Faculty f2 = new Faculty("Dr. Jones", "321 Elm St", "555-4444", "jones@email.com",
                                 "Room 102", 75000, LocalDate.of(2021,2,10),
                                 "10am-4pm", "junior");

        Staff st1 = new Staff("Karen", "987 Maple St", "555-5555", "karen@email.com",
                              "Admin Office", 50000, LocalDate.of(2019,5,20), "Secretary");
        Staff st2 = new Staff("Mike", "654 Cedar St", "555-6666", "mike@email.com",
                              "Maintenance", 45000, LocalDate.of(2018,6,10), "Custodian");

        // Write them to database
        db.writePerson(s1);
        db.writePerson(s2);
        db.writePerson(f1);
        db.writePerson(f2);
        db.writePerson(st1);
        db.writePerson(st2);

        // Read database and print
        ArrayList<Person> persons = db.readDatabase();
        for (Person p : persons) {
            System.out.println(p);
            System.out.println("=======");
        }
    }
}