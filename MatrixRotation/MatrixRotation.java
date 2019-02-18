package MatrixRotation;

import java.util.Scanner;

public class MatrixRotation {
	int[][] mat;
	
	public MatrixRotation(int m) {
		this.mat = new int[m][m];
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<m; j++) {
				this.mat[i][j] = (i*m)+j;
			}
		}
	}
	
	public void rot90() {
		int m = this.mat.length;
		int temp;
		for(int i = 0; i<m/2; i++) {
			temp = this.mat[i][i];
			//upper row
			for(int j = i; j<m-i-1; j++) {
				this.mat[i][j] = this.mat[i][j+1];
			}
//			this.print_mat();
			//right row
			for(int j = i; j<m-i-1; j++) {
				this.mat[j][m-i-1] = this.mat[j+1][m-i-1];
			}
//			this.print_mat();
			//bottom row
			for(int j = m-i-1; j>i; j--) {
				this.mat[m-i-1][j] = this.mat[m-i-1][j-1];
			}
//			this.print_mat();
			//left row
			for(int j = m-i-1; j>i+1; j--) {
				this.mat[j][i] = this.mat[j-1][i];
			}
			this.mat[i+1][i] = temp;
			
		}
	}
	
	public void print_mat() {
		int m = this.mat.length;
		for(int i = 0; i<m; i++ ) {
			for(int j = 0; j<m; j++) {
				System.out.print(""+this.mat[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		MatrixRotation mat = new MatrixRotation(m);
		mat.print_mat();
		mat.rot90();
		mat.print_mat();
//		int[][] mat = new int[m][n];
		scan.close();
	}
}
