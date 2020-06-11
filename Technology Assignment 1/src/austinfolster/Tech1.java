package austinfolster;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Tech1 {

	public static void main(String[] args) {
		
		//This while loop repeatedly prompts the user for their choice of power set or Cartesian product, then asks for either 1 or 2 sets.
		while (true) {
			
			System.out.println("Please press 1 for a Cartesian Product or 2 for a Power Set");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
		
			if (input.nextInt() == 1) {
				
				//if they choose to do a Cartesian product, i ask them for 2 sets, then i call the cartProd method to find the Cartesian product
				System.out.println("Please enter 2 sets with each element separated by a space:");
				input.nextLine();
				String set = input.nextLine();
				int[] x = toSet(set);;
				String set2 = input.nextLine();
				int[] y = toSet(set2);
				System.out.println(cartProd(x, y));
				
			} else {
				
				//if they choose to do a power set, i ask them for a set, then i call the pwrSet method to find the power set
				System.out.println("Please enter a set with each element separated by a space:");
				input.nextLine();
				String set = input.nextLine();
				int[] x  = toSet(set);
				System.out.println(pwrSet(x));
				
			}
		
		}
		
	}
	
	//this method simply take a string of a set separated by spaces and turns it into an integer array, which is easier to work with
	public static int[] toSet(String str) {
		
		String[] strArray = str.split(" ");
		int[] newInt = new int[strArray.length];
		
		for (int i = 0; i < newInt.length; i++) newInt[i] = Integer.parseInt(strArray[i]);
		
		return newInt;
		
	}
	
	//this method is for the Cartesian product
	//it takes an empty set 'product' and fills it with every ordered pair such that the first number is from the first set and the second number is from the second
	//The hashSet object doesn't allow any duplicate entries, so we never have to worry about duplicates.
	public static Set<String> cartProd(int[] x, int[] y) {
		
		Set<String> product = new HashSet<String>();
		
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				
				product.add("(" + x[i] + ", " + y[j] + ")");
				
			}
		}
		//we turn the 'product' into a tree set to organize it.
		Set<String> tree = new TreeSet<String>(product);
		return tree;
		
	}
	
	//A little more complicated, this is the method for the power set
	public static Set<String> pwrSet(int[] x) {
		
		//first we create the hash set that will be our power set, then we add the null set
		Set<String> pwr = new HashSet<String>();
		pwr.add("{}");
		
		//now we loop through the length of the power set, which will be 2^nth power
		 for(int counter = 0; counter < Math.pow(2, x.length); counter++) {
			 // we're going to create a set inside a set using 'temp'
			 String temp = "";
			 for(int j = 0; j < x.length; j++) {
				/* Check if jth bit in the  
				counter is set If set then  
				print jth element from set */
				 if((counter & (1 << j)) > 0) {
					temp += x[j] + ", ";
				    	
				 }
		
			 }
			
			//little bit of formatting to make it look pretty
			temp = "{" + temp + "}";
			temp = temp.replace(", }", "}");
		    //then we add it to the pwr set
		    pwr.add(temp);
		}
		 
		//we turn the 'pwr' set into a tree set to organize it.
		Set<String> tree = new TreeSet<String>(pwr);
		return tree;
		
	}
	
}