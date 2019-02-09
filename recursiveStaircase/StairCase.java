package recursiveStaircase;
import java.util.Scanner;
public class StairCase{
	static int[] stairs;

	public static void main(String argc[]){
		int n;
		if (argc.length != 0){
			n = Integer.valueOf(argc[0]);
		}else{
			System.out.print("Enter Value: ");
			Scanner scan = new Scanner(System.in);
			n = scan.nextInt();
			scan.close();
		}
		stairs = new int[n+1];
		stairs[0] = 1;
		stairs[1] = 1;
		stairs[2] = 2;
		for(int i = 3; i <= n; i++){
			stairs[i] = stairs[i-3] + stairs[i-2] + stairs[i-1];
		}
		System.out.println("Result : "+stairs[n]);
	}
}