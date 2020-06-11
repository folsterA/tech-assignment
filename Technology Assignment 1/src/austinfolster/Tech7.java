package austinfolster;

import java.util.Scanner;

public class Tech7 {

	public static void main(String[] args) {
		
		while (true) {
			//takes input dollar amount and finds change. note: lots of dollars have lots of quarters
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter a non-negative dollar amount to find it's change in quarters, dimes, nickels, and pennies:");
			float n = input.nextFloat();
			int count[] = new int[4];
			greedyChange(n, count);
			System.out.println(n + " can be made with " + count[0] + " quarters, " + count[1] + " dimes, " + count[2] + " nickels, and " + count[3] + " pennies.");
						
		}
						
	}
	
	//simple greedy algorithm using if statements. I feel like this could be more optimized.
	public static float greedyChange(float n, int[] count) {
		
		float Q = (float) 0.25, D = (float) .10, N = (float) .05, P = (float) .01;
		
		if (n >= Q) {
			count[0] ++;
			return greedyChange(n - Q, count);
		}
		if (n >= D) {
			count[1] ++;
			return greedyChange(n - D, count);
		}
		if (n >= N) {
			count[2] ++;
			return greedyChange(n - N, count);
		}
		if (n >= P) {
			count[3] ++;
			return greedyChange((n - P), count);
		}
		
		//count[3]++;
		return 0;
		
	}

}