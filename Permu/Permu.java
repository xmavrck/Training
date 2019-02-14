package Permu;

import java.util.Scanner;
import java.util.HashSet;

public class Permu {
//	public static HashSet<String> perms;
	
//	public static String prems_with_rep(String capturedString, String remainingString) {
//		if(remainingString.length() == 0) {
//			// found a permutation
//		}
//	}
	
	public static HashSet<String> premsWithRep(String s, int n){
		HashSet<String> perms = new HashSet<String>();
		if(n == s.length()) {
			for(int i = 0; i<s.length();i++) {
				perms.add(String.valueOf(s.charAt(i)));
			}
			return perms;
		}
		String currentChar= "";
		HashSet<String> temp = premsWithRep(s,n+1);
		for(int i = 0; i<s.length();i++) {
			currentChar = String.valueOf(s.charAt(i));
			for(String ss: temp) {
				perms.add(currentChar+ss);
			}
		}
		return perms;
	}
	
	public static String getRemainingString(String s, int i) {
		return s.substring(0, i)+s.substring(i+1, s.length());
	}
	
	public static HashSet<String> permsWithoutRep(String s) {
		HashSet<String> perms = new HashSet<String>();
		if(s.length() == 1) {
			perms.add(s);
			return perms;
		}
		String remainingString = "";
		String currentChar;
		for(int i=0; i<s.length(); i++) {
			currentChar = String.valueOf(s.charAt(i));
			remainingString = getRemainingString(s, i);
			for(String iperm: permsWithoutRep(remainingString)) {
				perms.add(currentChar+iperm);
			}
		}
		return perms;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String mainString = scan.nextLine();
		System.out.println("Without Rep:");
		for(String s: permsWithoutRep(mainString)) {
			System.out.println(s);		
		}
		
		System.out.println("\nWith Rep:");
		for(String s: premsWithRep(mainString, 1)) {
			System.out.println(s);		
		}
		scan.close();
		
	}

}
