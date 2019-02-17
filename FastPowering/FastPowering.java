package FastPowering;

import java.util.Scanner;

public class FastPowering {
	
	public static int power(int n, int p) {
		if(p==0) {
			return 1;
		}else {
			return n*power(n,p-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int p = scan.nextInt();
		System.out.println(power(n,p));
		scan.close();
	}

}
