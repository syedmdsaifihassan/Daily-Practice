/*
Print All Permutations Of A String Iteratively
Easy

1. You are given a string. 
2. You have to print all permutations of the given string iteratively.

Input Format
A String

Output Format
All permutations of the given string(one in a line). 

Constraints
1 <= length of string <= 15
Sample Input
abc

Sample Output
abc
bac
cab
acb
bca
cba

*/

import java.io.*;
import java.util.*;

public class PrintAllPermutationsOfAStringIteratively {

	public static void solution(String str){
		// write your code here
		
		int n1 = str.length(); 
        int n2 = 1;
        for(int i = 1; i<=n1; i++) {
            n2 = n2 * i;
        }
        
        for(int i=0; i<n2; i++){
            StringBuilder sb = new StringBuilder(str);
            
            int div = n1;
            int dvd = i;
            while(div != 0){
                int q = dvd/div;
                int r = dvd%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                dvd = q;
                div--;
            }
            System.out.println();
        }
        
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}