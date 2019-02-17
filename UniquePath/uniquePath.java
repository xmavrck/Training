package UniquePath;

import java.util.Scanner;

public class uniquePath {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] mat = new int[m][n];
		for(int i = 0;i<m; i++) {
			mat[i][0] = 1;
		}
		for(int i = 0;i<n; i++) {
			mat[0][i] = 1;
		}
		for(int i = 1; i<m; i++) {
			for(int j = 1; j<n; j++) {
				mat[i][j] = mat[i-1][j] + mat[i][j-1];
			}
		}
		System.out.println(mat[m-1][n-1]);
		scan.close();
	}

}
