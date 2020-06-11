package austinfolster;

import java.util.Scanner;

public class Tech5 {

	//This is a program to product the the and, or, xor, condition, and bi-conditional of 2 input booleans. Java has most of this
	//built in, but we needed to make the conditional and bi-conditional here.
	public static void main(String[] args) {
		
		while (true) {
			
			System.out.println("Input 'p' (1/0): ");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int p_in = input.nextInt();
			System.out.println("Input 'q' (1/0): ");
			int q_in = input.nextInt();
	
			boolean p = true, q = true;
			if (p_in == 0)  p = false;
			if (q_in == 0) q = false;
			System.out.println("p: " + p + "; q: " + q);
			
			System.out.println("p ^ q = " + (p&&q));
			System.out.println("p v q = " + (p||q));
			System.out.println("p xor q = " + (p^q));
			System.out.println("p --> q = " + con(p, q));
			System.out.println("p <=> q = " + bicon(p, q));
			System.out.println();
			
		}
	}
	
	//A conditional is always true unless the first boolean is true and the second is false. Fairly easy.
	public static boolean con(boolean p, boolean q) {
		
		if (p && !q) return false;
		
		return true;
		
	}
	
	//A bi-conditional is always false unless both booleans are equal
	public static boolean bicon(boolean p, boolean q) {
		
		if (p == q) return true;
		return false;
		
	}

}
