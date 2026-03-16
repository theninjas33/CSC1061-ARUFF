import java.io.*;
import java.util.ArrayList;

/**
 * Database class handles writing and reading Person objects to/from a file.
 */
public class Database {

    private static final String PERSON_DATABASE = "PersonDatabase.txt";

    public Database() {
        try {
            File file = new File(PERSON_DATABASE);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Write a Person object to file
    public void writePerson(Person p) {
        try (FileWriter fw = new FileWriter(PERSON_DATABASE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(p.getClass().getSimpleName());
            out.println(p.toString());
            out.println("-----");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read all persons from file
    public ArrayList<Person> readDatabase() {
        ArrayList<Person> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PERSON_DATABASE))) {

            String line;
            StringBuilder sb = new StringBuilder();
            String type = null;
            while ((line = br.readLine()) != null) {
                if (line.equals("-----")) {
                   
                    list.add(new Person(sb.toString(), "", "", ""));
                    sb.setLength(0); 
                } else if (type == null) {
                    type = line; 
                } else {
                    sb.append(line).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}