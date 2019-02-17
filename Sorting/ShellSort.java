package Sorting;

import java.util.Scanner;

public class ShellSort {

	static int[] arr;
	
	public static void insertionOnShell(int st, int gapSize) {
		int temp;
		for(int i = st+gapSize; i<arr.length; i+=gapSize) {
			temp = arr[i];
			int j = i;
			while(j>=gapSize && arr[j-gapSize] > temp) {
				arr[j] = arr[j-gapSize];
				j = j-gapSize;
			}
			arr[j] = temp;
		}
	}
	
	public static void shellSort() {
		int gapSize = arr.length / 2;
		while(gapSize > 0) {
			for(int st = 0; st<gapSize; st++) {
				insertionOnShell(st, gapSize);
			}
			gapSize = gapSize/2;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		arr = new int[size];
		shellSort();
		scan.close();
	}

}
