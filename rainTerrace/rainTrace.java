package rainTerrace;

import java.util.Scanner;

class GFG { 
      
    static int findWater(int arr[], int size) 
    { 
        int result = 0; 
        int left_max = 0, right_max = 0; 
        int low = 0, high = size-1; 
        while(low <= high){ 
            if(arr[low] < arr[high]){ 
                if(arr[low] > left_max) {
                	left_max = arr[low];
                }else {
                	result += left_max - arr[low]; 
                	low++;
                }
            }else{ 
                if(arr[high] > right_max) {
                	right_max = arr[high]; 
                }else {
                	result += right_max - arr[high]; 
                	high--;
                }
            } 
        }
        return result; 
    } 
      
    public static void main(String[] args)  
    { 
    	Scanner scan = new Scanner(System.in);
    	int size = scan.nextInt();
    	int[] arr = new int[size];
    	for(int i = 0; i<size; i++) {
    		arr[i] = scan.nextInt();
    	}
        System.out.println("Maximum water that "
                       + "can be accumulated is " 
                       + findWater(arr, size)); 
        scan.close();
    } 
} 