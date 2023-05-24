package br.com.dbarreto.challenge.book.crackingcodeinterview;

/**
 * Write a function to swap a number in place (that is, without temporary variables).
 */
public class NumberSwapper {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 23;
		
		System.out.println("At the start: a = " + a + ", b = " + b);
		
		a = a - b;
		b = a + b;
		a = b - a;
		
		System.out.println("At the end: a = " + a + ", b = " + b);
	}
}
