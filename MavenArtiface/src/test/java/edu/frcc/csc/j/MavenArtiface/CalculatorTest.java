package edu.frcc.csc.j.MavenArtiface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	void setup()  {
		calc = new Calculator();
		
	}
	
	
	@Test
	@DisplayName("Simple Adition")
	void testAdd() {
		assertEquals(10 calc.add(8, 2), "Addition no work")
		
	}
	
	@Test
	@DisplayName("Simple Multiplication")
	void testMultiply() {
		assertEquals(20, calc.multiply(4, 5), "Multiplication no work");
		assertTrue(calc.multiply(3, 6) == 18, "Answer should be");
	}
	
	@Test
	@DisplayName("Simple Division")
	@Disabled("Not ready for prime time")
	void testDivide() {
		assertEquals(3.0, calc.divide(6/2), "divide not working");
	}
	@Test
	void testDivideException() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, ()->calc.divide(1,  0));
		assertEquals("Divide by 0", exception.getmessage());
	}
}
