package NQueen;

import java.util.Scanner;
import java.lang.Math;

public class NQueen {

	public int[] sol;
	
	public NQueen(int size) {
		sol = new int[size];
		for(int i = 0; i<size; i++) {
			sol[i] = -10;
		}
	}
	
	private boolean goodFor(int n, int i) {
		if(n == 0) {
			return true;
		}
		for(int j = 0; j<n; j++) {
			if((Math.abs(n-i) == Math.abs(j-sol[j])) || 
					(Math.abs(n-j) == Math.abs(i-sol[j])) || 
						(i == this.sol[j])) { //same col
				return false;
			}
		}
		return true;
	}
	
	private boolean placeQueen(int n) {
		if(n == sol.length) {
			return true;
		}
		for(int i = 1; i<=sol.length; i++) {
			sol[n] = i;
			for(int k: sol) {
				System.out.println(k);
			}
			if(!(goodFor(n, i) && placeQueen(n+1))) {
				sol[n] = -10;
				for(int k: sol) {
					System.out.println(k);
				}
			}
		}
		if(sol[n] == -10) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		NQueen p = new NQueen(size);
		p.placeQueen(0);
		for(int i: p.sol) {
			System.out.println(i);
		}
		scan.close();
	}

}
