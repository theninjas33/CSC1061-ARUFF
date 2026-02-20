
public class Driver {

	public static void main(String[] args) {
		
			/**
			 * TEST THE CONVERSION METHODS.
			 * @param args command-line arguments
			 */
			
			for(String x: args) {
				System.out.println(x);
			}
			System.exit(0);
			
			double answer = 0.0;
			if(args.length < 2) {
				System.out.println("Useage:");
				System.out.println("\t-f <temp> to convert to fahrenheit");
				System.out.println("\t-f <temp> to convert to celsius");
				System.exit(-1);
			}
			if(args[0].equals("-f")) {
				answer = ConvertCelToFah(Double.parseDouble(args[1]));
				System.out.println( "The farenhrit value is" + answer);
			}
			else if (args[0].equals("-c")) {
				answer = ConvertFahToCel(Double.parseDouble(args[1]));
				System.out.println("The velsius value is " + answer);
			}
			else {
				System.out.println();
			
			}
	
			double temp = 32;
			System.out.println("The fahrenheit value is " + ConvertCelToFah(temp));
			
			double fah = 89.6;
			System.out.println("The celsius value is" + ConvertFahToCel(fah)); }

	private static double ConvertFahToCel(double double1) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double ConvertCelToFah(double double1) {
		// TODO Auto-generated method stub
		return 0;
	}

	}


