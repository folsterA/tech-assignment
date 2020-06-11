package austinfolster;

import java.util.Scanner;

public class Tech8 {

	public static void main(String[] args) {
		
		while (true) {
			
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter a non-negative integer to find it's value in the fibonacci sequence:");
			int n = input.nextInt();
			System.out.println(fib(n));
			
		}
		
	}
	
	//prints the value of n by recursion
	public static int fib(int n) {
		
		if (n < 0) return -1;
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n - 2) + fib(n - 1);
		
	}

}
