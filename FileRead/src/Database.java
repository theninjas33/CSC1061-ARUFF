import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;



public class Database {

	private File outFile = new File("database.csv");
	PrintWriter printer;
	Scanner reader;
	
	//constructors
	public Database() {
	}{
		try {
			if(!outFile.exists());
				outFile.createNewFile();
		
	}
	catch (IOException e) {
		System.out.println(e.Message());
		System.out.println("Could not create database");
		System.exit(-1);
	}
		try {
		printer = new PrintWriter(outFile.getName());
		scanner = new Scanner(outFile);
		
		}
		catch  (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Database coule not be created!");
			System.exit(-1);
		}
}
	public void write(GeometricObject shape) {
		printer.print(shape.getClass().getName());
		printer.print("," + shape.getColor());
		printer.print("," + shape.isFilled());
		if (shape instanceof Circle) {
			printer.print("," + ((Circle)shape).getRadius());
		}
		else if(shape instanceof Rectangle) {
			Rectangle rect = (Rectangle)shape;
			printer.print("," + rect.getHeight());
			printer.print("," + rect.getWidth());
		}
		{
		printer.println();
		printer.flush();
	}
		public GeometricObject readObject() {
			String line; 
			if(reader.hasNextLine()) {
				line = reader.nextLine();
		}
		else {
			return null;
		}
		String[] tokens = line.split(",");
		
		GeometricObject obj = null;
		if (tokens [0].equals("Circle")) {
			obj = new Circle(tokens[1].trim(),
					Boolean.parseBoolean(tokens[2]),
					Double.parseDouble(tokens[3]));
		}
		
		return obj;
		}
		else {
			return null;
		}
		String tokens = line.split(",");
		
		geometricObject obj = null;
		if (tokens [0].equals("Circle")) {
		}
	}