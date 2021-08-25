/*
Target Sum Subsets - Dp
Medium
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.

Input Format
A number n
n1
n2
.. n number of elements
A number tar

Output Format
true or false as required

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50

Sample Input
5
4
2
7
1
3
10

Sample Output
true

Asked in Companies
Google      2
Amazon      2
Facebook        10

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        
        // Boolean array is taken for MEMORIZATION method
        // Boolean[][] dp = new Boolean[n][target+1];
        // ----------------------------------------------
        
        // System.out.println(tss(arr, 0, target));
        
        System.out.println(tssTab(arr, target));
    }
    
    // Recursion & Memorization
    public static boolean tss(int[] arr, int idx, int target){
        if(target == 0){
            return true;
        }
        if(idx>=arr.length || target<0){
            return false;
        }
        
        // MEMORIZATION
        // if(dp[idx][target] != null){
        //     return dp[idx][target];
        // }
        // ------------
        
        boolean f1 = tss(arr, idx+1, target);
        boolean f2 = tss(arr, idx+1, target-arr[idx]);
        
        boolean ans = f1 || f2;
        
        // MEMORIZATION
        // dp[idx][target] = ans;
        // ------------
        
        return ans;
    }
    
    // Tabulation
    public static boolean tssTab(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length+1][target+1];
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = dp[i-1][j];
                if(dp[i][j]==false && j-arr[i-1]>=0){
                    dp[i][j] = dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}