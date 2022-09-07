package StringCalculatorTest;
import static org.junit.Assert.*;

import org.junit.Test;

import StringCalculator.Calculator;

public class CalculatorTest {
	//Task-1
	//for empty string it will return zero
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	//for single string it will return same string
	@Test
	public void shouldReturnNumberOnSingleString() {
		assertEquals(1, Calculator.add("1"));
	}

	//for two strings separated by commas it will return sum of the two
	@Test
	public void shouldReturnSumOfNumbersOnTwoStrings() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	//Task-2
    //for multiple strings separated by commas it will return sum of all
	@Test
	public void shouldReturnSumOfAllNumbers() {
		assertEquals(6,Calculator.add("1,2,3"));
	}
	
	//Test-3
   // Allow \n as delimiter along-with comma
	@Test
	public void shouldAllowNewLineAsDelimiter() {
		assertEquals(6,Calculator.add("1\n2,3"));
	}
}
