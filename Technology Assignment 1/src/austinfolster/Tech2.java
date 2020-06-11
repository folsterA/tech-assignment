package austinfolster;

import java.util.Scanner;

public class Tech2 {

	public static void main(String[] args) {
		//this while loop prompts the user to choose either a permutation, or a combination (both with repetition allowed), and then prompts for n elements and r choices.
		while (true) {
		
			System.out.println("Please press 1 for a combination or 2 for a permutaion:");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
		
			if (input.nextInt() == 1) {
				
				System.out.println("Please enter n elements from which you would like to choose r from, seperated by line breaks.");
				input.nextLine();
				int n = input.nextInt();
				int r = input.nextInt();
				System.out.println(nCr(n, r));
				
			} else {
				
				System.out.println("Please enter n elements from which you would like to choose r from, seperated by line breaks.");
				input.nextLine();
				int n = input.nextInt();
				int r = input.nextInt();
				System.out.println(nPr(n, r));
				
			}
			
		}	
		
	}
	
	//here's a method for a factorial since it doesn't exist in Java for whatever reason
	public static int factorial(int n) {
		
		if (n <= 2) return n;
		return n * factorial(n-1);
		
	}
	
	//Here's the method for taking n choose r with combinations where repetition is allowed.
	//normally combinations don't do duplicates, but here we can use the formula (n+r-1 C r)
	public static int nCr(int n, int r) {
		
		int c = n + r - 1;
		int f = factorial(c) / (factorial(c-r) * factorial(r));
		
		return f;
		
	}
	
	//Here's the method for taking n choose r with permutations where repetition is allowed.
	public static int nPr(int n, int r) {
		
		return (int) Math.pow(n, r);
		
	}

}
