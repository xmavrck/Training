package maths;

import java.util.Scanner;

public class BitManp {

	public static int set_bit_count(int n) {
		int count = 0;
		while(n>0) {
			if(n%2 == 1) {
				count++;
			}
			n = n/2;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		System.out.println("a|b : "+(i|j));
		System.out.println("a&b : "+(i&j));
		System.out.println("a^b : "+(i^j));
		System.out.println("~a : "+(~i));
		System.out.println("a>>b : "+(i>>j));
		System.out.println("a>>>b : "+(i>>>j));
		System.out.println("a<<b : "+(i<<j));
		scan.close();
	}
}
