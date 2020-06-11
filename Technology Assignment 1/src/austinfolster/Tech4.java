package austinfolster;

import java.util.Scanner;

public class Tech4 {

	public static void main(String[] args) {
		//This is a function for printing a... few combinations or permutations of the alphabet.
		String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		System.out.println("Please press 1 for a combination or 2 for a permutaion:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
	
		if (input.nextInt() == 1) {
			
			//print out 
			printCombination(alpha, 26, 4);
			
		} else {
			
			perm(alpha);
			
		}

		
	}
	
	//this is a function for printing out the permutation of the alphabet. It's relatively simple, just 
	//looping through each letter of the alphabet passed to it, making sure each letter in the permutation is unique.
	//This ends up printing a lot of code. Maybe limit it for the future?
	public static void perm(String[] x) {
		
		for (int i = 0; i < x.length; i++) {
						
			for (int j = 0; j < x.length; j++) {
				
				if (j == i) continue;
				
				for (int k = 0; k < x.length; k++) {	
					
					if (k == j || k==i) continue;
					
					for (int l = 0; l < x.length; l++) {
						if (l == i || l == j || l ==k) continue;
						
						System.out.println("{" + x[i] + ", " + x[j] + ", " + x[k] + ", " + x[l] + ", " + "}");						
						
					}
				}
			}
		}
	}
	
	//This is a bit of a more complicated way of making combinations, while still making each combination unique regardless of order.
	//This is the main function that is called, the printCombination()  function is just used for the temp array.
	public static void comb(String arr[], String data[], int start, int end, int index, int r) { 
		// Current combination is ready to be printed, print it 
		if (index == r) { 
			
			for (int j=0; j<r; j++) 
				System.out.print(data[j]+" "); 
			System.out.println(""); 
			return; 
			
		} 

		// replace index with all possible elements. The condition 
		// "end-i+1 >= r-index" makes sure that including one element 
		// at index will make a combination with remaining elements 
		// at remaining positions 
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) { 
			
			data[index] = arr[i]; 
			comb(arr, data, i + 1, end, index + 1, r); 
			
		} 
		
		
		
	}
	
	// The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses comb
    static void printCombination(String arr[], int n, int r) { 
    	
        // A temporary array to store all combination one by one 
        String data[] = new String[r]; 
  
        // Print all combination using temporary array 'data[]' 
        comb(arr, data, 0, n - 1 , 0, r); 
        
    } 
}
