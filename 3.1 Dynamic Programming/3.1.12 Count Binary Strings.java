/*
Count Binary Strings
Easy
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
Input Format
A number n

Output Format
A number representing the number of binary strings of length n with no consecutive 0's.

Constraints
0 < n <= 45

Sample Input
6

Sample Output
21

Asked in Companies
Microsoft       1
Flipkart        1
Morgan Stanley      1
Snapdeal        1

*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] dp1 = new int[n+1];   //ending at 0
    int[] dp2 = new int[n+1];   //ending at 1
    
    dp1[1] = 1;
    dp2[1] = 1;
    
    for(int i=2; i<dp1.length; i++){
        dp1[i] = dp2[i-1];
        dp2[i] = dp1[i-1]+dp2[i-1];
    }
    
    System.out.println(dp1[n]+dp2[n]);
 }

}