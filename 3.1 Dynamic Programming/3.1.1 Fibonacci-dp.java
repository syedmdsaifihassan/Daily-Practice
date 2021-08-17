/*
Fibonacci-dp
Easy
1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8

Input Format
A number n

Output Format
A number representing the nth element of fibonnaci sequence

Constraints
0 <= n <= 45

Sample Input
10

Sample Output
55

Asked in Companies
Microsoft       2
Amazon      3
Sap labs        3
Facebook        2
Apple       3

*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[n+1];
    
    System.out.println(fibonacci(n, dp));
 }
 
 public static int fibonacci(int n, int[] dp){
    if(n==0 || n==1){
        return n;
    }
    
    if(dp[n]!=0){
        return dp[n];
    }
    
    int a = fibonacci(n-1, dp);
    int b = fibonacci(n-2, dp);
    int c = a+b;
    dp[n] = c;
    return c;
 }
}