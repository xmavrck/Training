package Sets;

import java.util.Random;
import java.util.Scanner;

public class Set {
	public int size;
	public int[] arr;
		
	public Set(int s) {
		this.size = s;
		this.arr = new int[s];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<s; i++) {
			this.arr[i] = scan.nextInt();
		}
		scan.close();
	}
	
	public static int[][] cartesianProduct(Set s1, Set s2) {
		int[][] res = new int[s1.size*s2.size][2];
		for(int i = 0; i<s1.size; i++) {
			for(int j = 0; j<s2.size; j++) {
				res[i+j][0] = s1.arr[i];
				res[i+j][1] = s2.arr[i];
			}
		}		
		return res;
	}
	
	public static int[] yfShuffle(Set s1) {
		int[] res = s1.arr;
		int ind2;
		int temp;
		Random rand = new Random();
		for(int i = 0; i<s1.size-1; i--) {
			ind2 = rand.nextInt(s1.size - i);
			temp = res[s1.size-i-1];
			res[s1.size-i-1] = res[ind2];
			res[ind2] = temp;
		}
		return res;
	}
}