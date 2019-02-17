package CombinationalSum;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class CombinationalSum {

	static int[] elements;
	
	public static HashSet<ArrayList<Integer>> combiSum(int sm) {
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
//		ArrayList<Integer> tuple = new ArrayList<Integer>();
		for(int i = 0; i<elements.length; i++) {
			int forNow;
			if(sm>elements[i]) {
				forNow = elements[i];
//				find the combi sum of remaining if possible
				//and for each, attach forNow to it and the whole to set
				for(ArrayList<Integer> tuple: combiSum(sm-forNow)) {
					//if the tuple is bad, leave it
					if(tuple.get(0) != (int)Double.POSITIVE_INFINITY) {
						tuple.add(forNow);
						set.add(tuple);
					}
				}
			}else {
				// if this element is smaller than total sum, then here we can not form tuple
				// and also, elements greater than this will also be invalid
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add((int)Double.POSITIVE_INFINITY);
				set.add(temp);
			}
		}
		return set;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		elements = new int[size];
		int sumToBe = scan.nextInt();
		for(ArrayList<Integer> combin : combiSum(sumToBe)) {
			for(int i: combin) {
				System.out.print(""+i+" ");
			}
			System.out.println();
		}
		scan.close();
	}

}
