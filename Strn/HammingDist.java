package Strn;

import java.util.Scanner;

public class HammingDist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		if(s1.length() != s2.length()) {
			System.out.println("Invalid Input!!");
		}
		else {
			int count = 0;
			for(int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					count++;
				}
			}
			System.out.println("Distance: "+count);
		}
		scan.close();
	}

}
