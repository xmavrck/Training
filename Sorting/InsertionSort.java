package Sorting;

import java.util.Scanner;

public class InsertionSort {
	static int[] arr;
	
	public static void insertionSort(int[] arr) {
		int temp;
		for(int i = 1; i<arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				temp = arr[i];
				int j = i-1;
				while(j>=0 && arr[j] > temp) {
					arr[j+1] = arr[j];
					j--;
				}
				if(j<0) {
					arr[0] = temp;
				}else {
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = scan.nextInt();
		}
		insertionSort(arr);
		for(int i=0; i<size; i++) {
			System.out.println(arr[i]);
		}
		scan.close();
	}

}
