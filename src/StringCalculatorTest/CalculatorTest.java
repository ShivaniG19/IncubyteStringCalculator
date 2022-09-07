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
	
	//Task-3
   // Allow \n as delimiter along-with comma
	@Test
	public void shouldAllowNewLineAsDelimiter() {
		assertEquals(6,Calculator.add("1\n2,3"));
	}
	
	//Task-4
   //Allow custom delimiter by checking // in beginning of first line
	@Test
	public void shouldAllowCustomDelimiter() {
		assertEquals(3,Calculator.add("//;\n1;2"));
	}

	// Custom Delimiter can be custom Regex Character
	@Test
	public void shouldAllowRegexCharAsCustomDelimiter() {
		assertEquals(3,Calculator.add("//.\n1.2"));
	}
	
    //Task-5
	//Throw exception for negative numbers
	@Test
	public void shouldThrowExceptionForNegativeNumbers() {
		try{
			Calculator.add("1,-2,3");
			fail("Exception expected");
		}catch(RuntimeException e) {
		}
	}
  //Exception message should have negative number
	@Test
	public void shouldHaveNegativeNumbersInException() {
		try{
			Calculator.add("-1,-2,3");
			fail("Exception expected");
		}catch(RuntimeException e) {
			assertEquals("negatives not allowed: -1, -2",e.getMessage());
		}
	}
}
