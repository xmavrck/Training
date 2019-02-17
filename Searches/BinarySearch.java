package Searches;

import java.util.Scanner;

public class BinarySearch {

	public static int biSearch(int[] arr, int start, int end, int item) {
		if(start > end) {
			return -404;
		}
		else {
			int mid = (start+end)/2;
			if(arr[mid] == item) {
				return mid;
			}
			else if(arr[mid] > item) {
				return biSearch(arr, start, mid-1, item);
			}
			else {
				return biSearch(arr, mid+1, end, item);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter array in ascending form: ");
		for(int i = 0; i<size; i++) {
			arr[i] = scan.nextInt();
		}
		int item = scan.nextInt();
		int result = biSearch(arr, 0, arr.length-1, item);
		if(result != -404) {
			System.out.println("Element found at "+result+"th index.");
		}else {
			System.out.println("Error 404: Element not found!");
		}
		scan.close();
	}

}
