/*
Goldmine
Easy  Prev   Next
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
goldmine

6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.

Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements

Output Format
An integer representing Maximum gold available.

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000

Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Sample Output
33

Asked in Companies
Amazon      1
Flipkart        1

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        // int max = 0;
        // for(int i=0; i<arr.length; i++){
        //     max = Math.max(max, goldmineRec(arr, i, 0));
        // }
        // System.out.println(max);
        System.out.println(goldmine(arr));
    }

    // By Recursion
    public static int goldmineRec(int[][] arr, int sr, int sc){
        if(sr<0 || sr>=arr.length){
            return Integer.MIN_VALUE;
        }
        if(sc == arr[0].length-1){
            return arr[sr][sc];
        }
        
        int f1 = goldmineRec(arr, sr-1, sc+1);
        int f2 = goldmineRec(arr, sr, sc+1);
        int f3 = goldmineRec(arr, sr+1, sc+1);
        
        int ans = Math.max(f1, Math.max(f2, f3)) + arr[sr][sc];
        return ans;
    }
    
    // By Tabulation
    public static int goldmine(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int j=arr[0].length-1; j>=0; j--){
            for(int i=0; i<arr.length; i++){
                if(j == arr[0].length-1){   // last column
                    dp[i][j] = arr[i][j];
                }else if(i==0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i == arr.length-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                }else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1],dp[i+1][j+1]));
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<arr.length; i++){
            ans = Math.max(ans, dp[i][0]);
        }
        
        return ans;
    }
}