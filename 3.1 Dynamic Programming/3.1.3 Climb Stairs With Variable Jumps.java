/*
Climb Stairs With Variable Jumps
Easy
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.  
    You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.

Input Format
A number n
.. n more elements

Output Format
A number representing the number of ways to climb the stairs from 0 to top.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 20

Sample Input
10
3
3
0
2
1
2
4
2
0
0

Sample Output
5

Asked in Companies
BlackRock       1

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
        int[] dp = new int[n+1];
        System.out.println(cswj(arr, 0, dp));
    }
    
    public static int cswj(int[] arr, int i, int[] dp){
        if(i==arr.length){
            return 1;
        }
        if(i>arr.length){
            return 0;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        int ans = 0;
        for(int j=1; j<=arr[i]; j++){
            ans = ans + cswj(arr, i+j, dp);
        }
        dp[i] = ans;
        return ans;
    }
    
    public static int cswjTrab(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 1;  // destn -> destn(1)
        
        for(int i=n-1; i>=0; i--){
            for(int jump = 0; jump<= arr[i]; jump++){
                if(i+jump <= n){
                    dp[i] = dp[i+jump];
                }
            }
        }
        
        return dp[0];
    }
}