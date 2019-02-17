package Sorting;

import java.util.Scanner;

public class RadixSort {

	static int[] mainArr;
	
	public static String[] intToStrArr(int[] arr) {
		String[] stArr = new String[arr.length];
		int maxLength = 0;
		for(int i = 0; i<arr.length; i++) {
			stArr[i] = String.valueOf(arr[i]);
			if(maxLength < stArr[i].length()) {
				maxLength = stArr[i].length();
			}
		}
		String zero = "0";
		int toAdd;
		for(int i = 0; i<arr.length; i++) {
			toAdd = maxLength-stArr[i].length();
			for(int j = 0; j<toAdd; j++) {
				stArr[i] = zero + stArr[i];
			}
		}
		return stArr;
	}
	
	public static int[] strToIntArr(String[] stArr) {
		int[] a = new int[stArr.length];
		for(int i = 0; i<stArr.length; i++) {
			a[i] = Integer.parseInt(stArr[i]);
		}
		return a;
	}
	
	public static void radixSort() {
		String[] stArr = intToStrArr(mainArr);
		int maxLength = stArr[0].length();
		String temp;
		for(int i = maxLength-1; i>=0; i--) {
			for(int j = 0; j<mainArr.length; j++) {
				 for(int k = 0; k<(mainArr.length-j-1); k++) {
					 if(stArr[k].charAt(i) > stArr[k+1].charAt(i)) {
						 temp = stArr[k];
						 stArr[k] = stArr[k+1];
						 stArr[k+1] = temp;
					 }
				 }
			}
		}
		mainArr = strToIntArr(stArr);
		for(int i: mainArr) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		mainArr = new int[size];
		for(int i = 0; i<size; i++) {
			mainArr[i] = scan.nextInt();
		}
		radixSort();
		for(int i: mainArr) {
			System.out.println(i);
		}
		scan.close();
	}

}
