package edu.frcc.csc.j.MavenArtiface;

public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
		
	}
	
	public int myltiply(int a, int b) {
		return a * b;
	}
	
	public double divide(int a,int b) {
		if (b == 0) {
			throw new ArithmeticException("divide by 0")
		}
		return a/b;
	}
	
}