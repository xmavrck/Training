package Sets;

import java.util.Scanner;

public class CartesianProduct {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size1 = scan.nextInt();
		Set s1 = new Set(size1);
		
		int size2 = scan.nextInt();
		Set s2 = new Set(size2);
		
		int[][] res = Set.cartesianProduct(s1, s2);
		
		for(int i = 0; i<res.length; i++) {
			System.out.println("("+res[i][0]+", "+res[i][1]+")");
		}
		
		scan.close();
		
	}
}
