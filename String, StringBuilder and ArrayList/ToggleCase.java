/*
Toggle Case
Easy

1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to toggle the case of every character of the given string.

Input Format
A String

Output Format
A String

Constraints
1 <= length of string <= 1000

Sample Input
pepCODinG

Sample Output
PEPcodINg

*/

import java.io.*;
import java.util.*;

public class ToggleCase {

	public static String toggleCase(String str){
		//write your code here
		String ans = "";
		
		for(int i=0; i<str.length(); i++){
		    
		    String temp="";
		    temp += str.charAt(i);
		    
		    if(str.charAt(i) >= 65 && str.charAt(i) <= 96){
		        ans += temp.toLowerCase();
		    }else{
		        ans += temp.toUpperCase();
		    }
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}