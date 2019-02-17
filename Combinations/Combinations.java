package Combinations;

import java.util.HashSet;
import java.util.Scanner;

public class Combinations {
	
	public static HashSet<String> combiw(String s, int i){
		HashSet<String> set = new HashSet<String>();
		if(i == 1) {
			set.add("");
			for(char c: s.toCharArray()) {
				set.add(String.valueOf(c));
			}
			return set;
		}
		for(int ind = 0; ind<s.length(); ind++) {
			String currentChar = String.valueOf(s.charAt(ind));
			String remaining = s.substring(ind, s.length());
			for(String st: combiw(remaining, i-1)) {
				set.add(st);
				set.add(currentChar+st);
			}
		}
		return set;
	}

	public static HashSet<String> combi(String s) {
		HashSet<String> set = new HashSet<String>();
		if(s.length() == 1) {
			set.add("");
			set.add(s);
			return set;
		}
		String currentChar = String.valueOf(s.charAt(0));
		String remaining = s.substring(1, s.length());
		for(String i: combi(remaining)) {
			set.add(i);
			set.add(currentChar+i);
		}
		
		return set;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println("Without : ");
		for(String i: combi(s)) {
			System.out.println("'"+i+"'");
		}
		System.out.println("\nWith : ");
		for(String i: combiw(s, s.length())) {
			System.out.println("'"+i+"'");
		}
		scan.close();
	}

}
