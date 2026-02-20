/*
 * 
 */

import java.util.Arrays;


/**
 * Methods to convert temp from fah to cel.
 * 
 * @author Austin
 * @author Kishmore
 */

public class TempConverter {

	
	public final double FREEZING_TEMP_IN_CELSIUS = 0;
	public final double FREEZING_TEMP_IN_FAHRENHEIT = 32;
	 /** 
	  * converts temp from fah to cel
	  * @peram temp in fah
	  * @return temp in cel
	  */
	
	
	public static double ConvertFahToCel(double input) {
		return((input - 32) * (5.0/9.0));
		
	}
	 /**
	  * converts temp from cel to fah
	  *
	  * @param temp in cel
	  * @return temp in fah
	  */
	public static double ConvertCelToFah(double input) {
		return input *(9.0/5.0) + 32;
	}
}
