package austinfolster;

import java.util.Scanner;

public class Tech3 {

	public static void main(String[] args) {

		while (true) {
			//this while loop prompts the user for 2 integers and takes the combination of them
			System.out.println("Please enter the constant you would like to calculate:");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int r = input.nextInt();
			System.out.println("Please enter how many nonnegative integer terms you would like to combine together to get your constant:");
			int n = input.nextInt();
			System.out.println("The above equation has " + nCr(n, r) + "  possible combinations.");

		}

	}

	//here's a method for a factorial since it doesn't exist in Java for whatever reason
	public static long factorial(int n) {
		
		if (n <= 2) return n;
		return n * factorial(n-1);
	
	}
	
	//Here's the method for taking n choose r with combinations where repetition is allowed.
	//normally combinations don't do duplicates, but here we can use the formula (n+r-1 C r)
	public static long nCr(int n, int r) {
		
		int c = n + r - 1;
		long f = factorial(c) / (factorial(c-r) * factorial(r));
		return f;
		
	}
	
}