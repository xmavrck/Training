package KnapsackProblem;

import java.util.Scanner;
import java.lang.Math;

public class Knapsack {
	public static int[][] matrix;
	public static item[] data;
	public static int capacity;
	
	public static void get_data(int n) {
		Scanner scan = new Scanner(System.in);
		data = new item[4];
		String s;
		String[] ss;
		for(int i = 0; i<n; i++) {
			s = scan.nextLine();
			ss = s.split(",");
			data[i] = new item(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
		}
		scan.close();
	}
	
	public static int includingThisElement(int i, int j) {
		if((j-data[i-1].weight) < 0) {
			return matrix[i-1][0];
		}
		return data[i-1].value+matrix[i-1][(j-data[i-1].weight)];
	}
	
	public static int kanpsack() {
		for(int i=0; i<=data.length; i++) {
			matrix[i][0] = 0;
		}
		for(int i = 0; i<=capacity; i++) {
			matrix[0][i] = 0;
		}
		for(int i = 1; i<=data.length; i++) {
			for(int j = 1; j<=capacity; j++) {
				matrix[i][j] = Math.max(matrix[i-1][j], includingThisElement(i,j));
			}
		}
		return matrix[data.length][capacity];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Capacity: ");
		capacity = scan.nextInt();
		System.out.println("Enter Number of Items: ");
		int n = scan.nextInt();
		matrix = new int[n+1][capacity+1];
		get_data(n);
		System.out.println("Profit : "+kanpsack());
		scan.close();
	}

}
