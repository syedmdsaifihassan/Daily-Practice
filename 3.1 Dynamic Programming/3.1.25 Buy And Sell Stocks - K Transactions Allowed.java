/*
Buy And Sell Stocks - K Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

Input Format
A number n
.. n more elements
A number k

Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2

Sample Input
6
9
6
7
6
3
8
1

Sample Output
5

Asked in Companies
Google      3
Amazon      9

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();
        int[][] dp = new int[k+1][n];
        for(int i=1; i<dp.length; i++){
            int max = dp[i-1][0] - arr[0];
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = Math.max(dp[i][j-1], max+arr[j]);
                max = Math.max(max, dp[i-1][j] - arr[j]);
            }
        }
        
        System.out.println(dp[k][n-1]);
    }

}