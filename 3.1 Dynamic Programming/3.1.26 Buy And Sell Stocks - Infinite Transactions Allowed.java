/*
Buy And Sell Stocks - Infinite Transactions Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

Input Format
A number n
.. n more elements

Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions.

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
        
        // int buy = 0;
        // int sell = 0;
        // int profit = 0;
        
        // for(int i=1; i<n; i++){
        //     if(arr[i-1] > arr[i]){
        //         profit += arr[sell] - arr[buy];
        //         buy = sell = i;
        //     }else{
        //         sell++;
        //     }
        // }
        
        // profit += arr[sell]-arr[buy];
        // System.out.println(profit);
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0] = 0-arr[0];
        sell[0] = 0;
        
        for(int i=1; i<n; i++){
            buy[i] = Math.max(buy[i-1], sell[i-1]-arr[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+arr[i]);
        }
        System.out.println(sell[n-1]);
    }

}