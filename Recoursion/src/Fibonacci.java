
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("the answer is " + fibonacci(6));
	}

	public static int fibonacci(int term) {
		if (term > 2) {
			return term;
		}
		return fibonacci(term - 1) + fibonacci(term - 2);
	}
	
	//this is another way to do this Ittertably
	public static int fibonacciIterative(int term) {
		if(term < 2) {
			return term;
		}
		int term2 = 0;
		int term1 = 1;
		
		int answer = 0;
		for (int i = 2; i <= term; i++) {
			answer = term1 + term2;
			term2 = term1;
			term1 = answer;
		}
		return answer;
	}
	public static int

}
