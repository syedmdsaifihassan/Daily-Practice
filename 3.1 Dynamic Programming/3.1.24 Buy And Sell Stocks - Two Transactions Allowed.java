/*
Buy And Sell Stocks - Two Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

Input Format
A number n
.. n more elements

Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10

Sample Input
9
11
6
7
19
4
1
6
18
4

Sample Output
30

Asked in Companies
Amazon      4
Bloomberg       2
Two Sigma       3

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
        
        int minsf = arr[0];
        int maxsf = arr[n-1];
        
        // dp1[i] -> Max profit by doing at most one txn till ith idx
        int[] dp1 = new int[n];
        for(int i=1; i<n; i++){
            minsf = Math.min(minsf, arr[i]);
            dp1[i] = Math.max(dp1[i-1], arr[i]-minsf);
        }
        
        // dp2[i] -> Max profit by doing at most one txn from ith idx to last idx
        int[] dp2 = new int[n];
        for(int i=n-2; i>=0; i--){
            maxsf = Math.max(maxsf, arr[i]);
            dp2[i] = Math.max(dp2[i+1], maxsf-arr[i]);
        }
        
        int maxP = 0;
        for(int i=0; i<n; i++){
            maxP = Math.max(maxP, dp1[i]+dp2[i]);
        }
        System.out.println(maxP);
    }

}