/*
 *Find all the interleavings of given strings 
 */

import java.util.*;

public class Program1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first string:");
		String str1 = sc.next();
		System.out.println("Enter second string:");
		String str2 = sc.next();
		findInterLeavings(str1, str2, " ");
		sc.close();
	}
	
	static void findInterLeavings(String str1, String str2, String result) { //To find all the interleavings of the given strings
		if(str1 == null) { //If str1 is empty, just print str2
			System.out.println(str2);
			return;
		}
		
		if(str2 == null) { //If str2 is empty, just print str1
			System.out.println(str1);
			return;
		}
		
		if(str1.length() == 0 && str2.length() == 0) //If both are empty, just print the result
			System.out.println(result);
		
		if(str1.length() > 0) //If str1 is not empty, then add characters from str1 to result
			findInterLeavings(str1.substring(1), str2, result + str1.charAt(0));
		
		if(str2.length()>0) //If str2 is not empty, then add characters from str2 to result
			findInterLeavings(str1, str2.substring(1), result + str2.charAt(0));
	}
}
