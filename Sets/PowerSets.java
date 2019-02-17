package Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PowerSets {
	public static int[] remaining(int[] s, int ind) {
		int[] remain = new int[s.length-1];
		int k = 0;
		for(int i = 0; i<s.length; i++) {
			if(i == ind) {
				continue;
			}
			remain[k++] = s[i];
		}
		return remain;
	}
	
	public static HashSet<ArrayList<Integer>> powerSet(int[] s) {
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		if(s.length == 1) {
			set.add(new ArrayList<Integer>());
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(s[0]);
			set.add(temp);
			return set;
		}
		int currentInt = s[0];
		int[] remaining = remaining(s, 0);
		ArrayList<Integer> temp;
		for(ArrayList<Integer> i : powerSet(remaining)) {
			set.add(i);
			temp = new ArrayList<Integer> (i);
			temp.add(currentInt);
			set.add(temp);
		}
		return set;
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int qty = scan.nextInt();
		int[] arr = new int[qty];
		for(int i = 0; i<qty; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(ArrayList<Integer> subSet: powerSet(arr)) {
			System.out.print("{");
			while(subSet.size() > 1) {
				System.out.print(""+subSet.remove(0)+",");
			}
			try {
				System.out.print(""+subSet.get(0));
			}
			catch(IndexOutOfBoundsException e) {
				
			}
			System.out.println("}");
		}
		scan.close();
	}
}
