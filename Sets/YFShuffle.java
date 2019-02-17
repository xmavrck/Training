package Sets;

import java.util.Scanner;

public class YFShuffle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set s = new Set(scan.nextInt());
		int[] res = Set.yfShuffle(s);
		for(int i: res) {
			System.out.println(""+i+"");
		}
		scan.close();
	}

}
