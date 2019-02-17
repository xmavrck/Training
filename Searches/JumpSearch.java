package Searches;

import java.util.Scanner;
import java.lang.Math;

public class JumpSearch {

	public static int jumpSearch(int[] arr, int item, int chunkSize) {
		int i = chunkSize-1;
		int preI = -1;
		while(i<arr.length) {
			if(arr[i] < item) {
				preI = i;
				i += chunkSize;
			}
			else if(arr[i] == item) {
				return i;
			}
			else {
				break;
			}
		}
		if(arr[i] < item) {
			preI = i;
			i = arr.length-1;
		}
		for(int k = i; k>preI; k--) {
			if(arr[k] == item) {
				return k;
			}
		}
		return -404;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int chunkSize = (int) (Math.sqrt(size) + 1);  
		int[] arr = new int[size];
		System.out.println("Enter array in ascending form: ");
		for(int i = 0; i<size; i++) {
			arr[i] = scan.nextInt();
		}
		int item = scan.nextInt();
		int result = jumpSearch(arr, item, chunkSize);
		if(result != -404) {
			System.out.println("Element found at "+result+"th index.");
		}else {
			System.out.println("Error 404: Element not found!");
		}
		scan.close();
	}

}
