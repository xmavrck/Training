package Sorting;

import java.util.Scanner;

public class QuickSort {

	static int[] arr;
	
	public static int partition(int lower, int upper) {
		if(lower == upper) {
			return upper;
		}
		if(upper-lower == 1) {
			if(arr[lower] > arr[upper]) {
				int temp = arr[lower];
				arr[lower] = arr[upper];
				arr[upper] = temp;
			}
			return lower;
		}
		
		int pivot = arr[upper];
		int i = lower-1;
		int temp;
		for(int j = 0; j<upper; j++) {
			if(arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[i+1];
		arr[i+1] = arr[upper];
		arr[upper] = temp;
		return i+1;
	}
	
	public static void quickSort(int lower, int upper) {
		if(lower<upper) {
			int pivotIndex = partition(lower, upper);
			quickSort(lower, pivotIndex-1);
			quickSort(pivotIndex+1, upper);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = scan.nextInt();
		}
		quickSort(0, size-1);
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
		scan.close();
	}

}
