/*
Climb Stairs
Easy
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.

Input Format
A number n

Output Format
A number representing the number of ways to climb the stairs from 0 to top.

Constraints
0 <= n <= 20

Sample Input
4

Sample Output
7

Asked in Companies
Microsoft       2
Adobe       3
Salesforce      1
Google      4
Amazon      8
Facebook        5
Apple       3

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];    // 
        System.out.println(climbStairs(n, dp));
    }
    
    public static int climbStairs(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int f1 = climbStairs(n-1, dp);
        int f2 = climbStairs(n-2, dp);
        int f3 = climbStairs(n-3, dp);
        
        int ans = f1+f2+f3;
        dp[n] = ans;
        return ans;
    }
    
    public static int climbStairsTrabulation(int n){
        int[] dp = new int[n+1];
        
        dp[0] = 1; // 0->0, no. of ways-1
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1];
            if(i-2 >= 0){
                dp[i] = dp[i-2];
            }
            if(i-3 >= 0){
                dp[i] = dp[i-3];
            }
        }
        return dp[n];
    }

}