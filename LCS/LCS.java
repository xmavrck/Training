package LCS;
import java.util.Scanner;
import java.lang.Math;

public class LCS {
	public static int[][] mat;
	// as a class, both the input strings should also be its member variable
	
	public static int lengthOfLCS(String s1, String s2) {
		int str1L = s1.length();
		int str2L = s2.length();
		mat = new int[str1L+1][str2L+1];
		for(int i = 0; i<=str1L; i++) {
			mat[i][0] = 0;
		}
		for(int i = 0; i<=str2L; i++) {
			mat[0][i] = 0;
		}
		for(int i = 1; i<=str1L; i++) {
			for(int j = 1;j<=str2L; j++) {
//				if the character matches at this place pick the diagonal and increment by 1
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					mat[i][j] = mat[i-1][j-1]+1;
				}
//				else pic the max of left one or the above
				else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat[str1L][str2L];
	}
	
	public static String stringOfLCS(String s1, String s2) {
		// as we have made changes, 
		// we can be trace them in last row or column of the main mat
		String res = "";
		int i = s1.length();
		int j = s2.length();
		while(mat[i][j] != 0) {
			if(mat[i][j] != mat[i-1][j]) {
				res += s1.charAt(i-1);
			}
			i--;
		}
		String Temp = "";
		for(int k = res.length()-1; k>=0 ;k--) {
			Temp += res.charAt(k);
		}
		return Temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		System.out.println("Length of Longest Common Subsequence: "+lengthOfLCS(str1, str2));
		System.out.println("Longest Common Subsequence is: '"+stringOfLCS(str1, str2)+"'");		
		scan.close();
	}
}
