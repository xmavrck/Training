package Searches;

import java.util.Scanner;
import java.util.ArrayList;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
				arr.add(scan.nextInt());
			}
			catch(Exception e) {
				break;
			}
		}
		System.out.println("Enter the item to be searched: ");
		int item = scan.nextInt();
		for(int i: arr) {
			if(i == item) {
				System.out.println("Found Element "+i+" at "+(arr.indexOf(i)+1)+"th index.");
				break;
			}
		}
		scan.close();
	}

}
