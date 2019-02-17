package FIbb;

import java.util.Scanner;

public class fibbo {

	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		arr = new int[size];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i<=size; i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		for(int i : arr) {
			System.out.println(i);
		}
		scan.close();
	}

}
