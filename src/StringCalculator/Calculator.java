package StringCalculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import StringCalculator.Calculator;

public class Calculator {
	public static int add(String numbers) {
		return 0;
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
