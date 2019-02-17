package Searches;

import java.util.Scanner;

public class InterpolationSearch {
	public static int interpoSearch(int[] arr, int item) {
		int lower = 0;
		int upper = arr.length-1;
		while(lower<=upper && item>=arr[lower] && item<=arr[upper]) {
			if(lower == upper && arr[lower] == item) {
				return upper;
			}else if(lower == upper) {
				return -404;
			}
			int pos = lower + (((upper-lower) / (arr[upper]-arr[lower])) * (item-arr[lower]));
			if(arr[pos] == item) {
				return pos;
			}
			else if(arr[pos] < item) {
				lower = pos+1;
			}
			else {
				upper = pos-1;
			}
		}
		return -404;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<size; i++) {
			arr[i] = scan.nextInt();
		}
		int item = scan.nextInt();
		int result = interpoSearch(arr, item);
		if(result != -404) {
			System.out.println("Element found at "+result+"th index.");
		}else {
			System.out.println("Element not Found!");
		}
		scan.close();
	}
}
