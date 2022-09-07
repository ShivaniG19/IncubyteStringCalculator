package StringCalculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import StringCalculator.Calculator;

public class Calculator {
	public static int add(String numbers) {
		String[] num = split(numbers);
		int size=num.length;
		throwExceptionIfAnyNegativeValue(num, size);
		return calculateSum(num, size);
	}
	public static void throwExceptionIfAnyNegativeValue(String[] num, int size) {
		ArrayList<String> neg = new ArrayList<String>();
		//Checking for the negative number in String
		for(int i=0; i<size; i++) {
			if(toInteger(num[i])<0) {
				neg.add(num[i]);
			}
		}
		if(neg.size()>0) {
			throw new RuntimeException("negatives not allowed: " + String.join(", ",neg));
		}
	}
	public static int calculateSum(String[] num, int size) {
		int sum=0;
		for(int i=0; i<size; i++){
			sum = sum + toInteger(num[i]);
		}
		return sum;
	}
	public static int toInteger(String numbers) {
		return Integer.parseInt(numbers);
	}

	public static String[] split(String numbers) {
		if(numbers.isEmpty()) {
			return new String[0];
		} else if(isCustDelimString(numbers)) {
			return splitUsingDelim(numbers);
		}
		return splitUsingCommaAndNewLine(numbers);
	}
    //Checking for Custom Delimiter in String
	public static boolean isCustDelimString(String numbers) {
		return numbers.startsWith("//");
	}
    //Split String on comma and Newline
	public static String[] splitUsingCommaAndNewLine(String numbers) {
		String[] num=numbers.split(",|\n");
		return num;
	}
    //Split String on Custom Delimiter
	public static String[] splitUsingDelim(String numbers) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
		m.matches();
		String customDelim = m.group(1);
		String num=m.group(2);
		return num.split(Pattern.quote(customDelim));
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(Calculator.add(str));
	sc.close();
	}
}
