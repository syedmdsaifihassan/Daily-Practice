/*
Partition Into Subsets

1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34

Input Format
A number n
A number k
Output Format
A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.

Constraints
0 <= n <= 20
0 <= k <= n

Sample Input
4
3
Sample Output
6

*/

import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubsetTab(int n, int k) {
        // write your code here
        if(n==0 || k==0 || n<k){
            return 0;
        }
        
        long[][] dp = new long[k+1][n+1];
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j<i){
                    dp[i][j] = 0;
                }else if(j==i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1]*i;
                }
            }
        }
        
        return dp[k][n];
    }
    
    public static long partitionKSubsetMem(int n, int k, long[][] dp){
        if(n==0 || k==0 || n<k){
            return 0;
        }
        if(n==k){
            return 1;
        }
        
        if(dp[n][k] != 0){
            return dp[n][k];
        }
        long f1 = partitionKSubsetMem(n-1, k-1, dp);
        long f2 = partitionKSubsetMem(n-1, k, dp) * k;
        
        long ans = f1+f2;
        return ans;
    } 
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        // tabulation
        // long res = partitionKSubsetTab(n, k);
        // System.out.println(res);
        
        // memorization
        long[][] dp = new long[n+1][k+1];
        long res = partitionKSubsetMem(n, k, dp);
        System.out.println(res);
    }
}