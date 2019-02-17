package TowerOfHanoi;

import java.util.Scanner;

class TOH 
{ 
	static void towerOfHanoi(int n, char fromRod, char toRod, char auxiRod) 
	{ 
		if (n == 1) 
		{ 
			System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod); 
			return; 
		} 
		towerOfHanoi(n-1, fromRod, auxiRod, toRod); 
		System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod); 
		towerOfHanoi(n-1, auxiRod, toRod, fromRod); 
	} 
	
	public static void main(String args[]) 
	{
		Scanner scan = new Scanner(System.in);
		int numOfDisks = scan.nextInt(); // Number of disks
      	// A is fromRod and C is toRod, B is auxillary rod
		towerOfHanoi(numOfDisks, 'A', 'C', 'B');
		scan.close();
	} 
} 
