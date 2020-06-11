package austinfolster;

import java.util.Arrays;
import java.util.Scanner;

public class Tech6 {

	public static void main(String[] args) {
		
		//take input set
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter any number of itegers separated by a space (it will be sorted for you):");
		String set = input.nextLine();
		
		//Set up 'arry' to be a sorted array of the inputed set and print it 
		String[] strArry = set.split(" ");
		int[] arry = new int[strArry.length];
		for (int x = 0; x < arry.length; x++) arry[x] = Integer.parseInt(strArry[x]);
		
		//Sort 'arry'
		arry = sort(arry, arry.length);
		System.out.println("Sorted array: " + Arrays.toString(arry));
		
		//Ask for integer to search for
		System.out.println("Please enter what number in the list you would like the index for:");
		int x = input.nextInt();
		
		//print out the linear, binary, and ternary sorts of the list
		System.out.println("linear sort returns index: " + linear(arry, arry.length, x));
		System.out.println("binary sort returns index: " + binary(arry, arry.length, x));
		System.out.println("ternary sort returns index: " + ternary(arry, arry.length, x, 0));

	}
	
	//ez pz bubble sorting method
	public static int[] sort(int[] arry, int n) {
		
		int temp;
		
		for (int i = 0; i < n - 1; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
				
				if (arry[j] > arry[j+1]) {
					
					temp = arry[j];
					arry[j] = arry[j+1];
					arry[j + 1] = temp;
					
				}
				
			}
			
		}
		
		return arry;
		
	}
	
	//just loop through and find x
	public static int linear(int[] arry, int n, int x) {
		
		for (int i = 0; i < n; i++) if (arry[i] == x) return i;
		
		return -1;
	
	}
	
	//a binary search. The classic
	public static int binary(int[] arry, int n, int x) {
		
		int l = 0, r = n, m;
	
		while (l < r) {
			
			m = (l+r)/2;
			if (arry[m] < x) l = m+1;
			else r = m;
			
		}
		
		return l;
	}
	
	//I had to learn about this one, it turned out to be easiest as a recursive function using the arrays class and just
	//splitting it into thrids with l and r, checking which third x falls on and calling the function again
	public static int ternary(int[] arry, int n, int x, int index) {
		
		int[] temp;
		if (arry[0] == x) return index;
		int l = n/3, r = (2 * n)/3;
		if (n==1) return -1;
		
		if (arry[l] == x) return index + l;
		if (arry[r] == x) return index + r;
		if (arry[l] > x ) {
		
			temp = Arrays.copyOfRange(arry, 0, l);
			index += l;
			return ternary(temp, temp.length, x, index);
			
		} else if (arry[r] < x) {
			
			temp = Arrays.copyOfRange(arry, r, n);
			index += l;
			return ternary(temp,temp.length, x, index);
			
		} else {
			
			temp = Arrays.copyOfRange(arry, l, r);
			index += l;
			return ternary(temp, temp.length, x, index);
			
		}
			
	}

}
