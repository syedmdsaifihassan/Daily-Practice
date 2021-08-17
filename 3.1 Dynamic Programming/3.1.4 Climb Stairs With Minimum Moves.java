/*
Climb Stairs With Minimum Moves
Easy
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of 
     staircase.
Note -> If there is no path through the staircase print null.

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
4

Asked in Companies
Amazon      3
Bloomberg       2
Yahoo       2

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
        System.out.println(minMoves(arr));
    }

    public static int minMoves(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int min = Integer.MAX_VALUE - 1;
            for(int jump=1; jump<=arr[i]; jump++){
                if(i+jump < dp.length){
                    min = Math.min(min, dp[i+jump]);
                }
            }
            
            dp[i] = min+1;
        }
        return dp[0];
    }
}