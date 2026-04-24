import java.math.BigDecimal;

public class BigDecimalPractice {

	public static void main(String[] args) {
		
		double num = 0.101;

		double ans = num * num;
		
		BigDecimal ans1 = BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(num));
		
		System.out.println("Answer: " + ans);
		
		System.out.println("Answer1: " + ans1);

	}

}
