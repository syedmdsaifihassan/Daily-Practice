/*
Paint Fence
Easy
1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.

Input Format
A number n
A number k

Output Format
A number representing the number of ways in which the fences could be painted so that not more than two fences have same colors.

Constraints
1 <= n <= 10
1 <= k <= 10

Sample Input
8
3

Sample Output
3672

Asked in Companies
Google    3

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();   
        // int[] dp1 = new int[n+1];   //last 2 fences are painted with same color
        // int[] dp2 = new int[n+1];   //last 2 fences are painted with diff color
        
        // dp2[1] = k;
        // for(int i=2; i<=n; i++){
        //     dp1[i] = dp2[i-1];
        //     dp2[i] = (dp1[i-1]+dp2[i-1])*(k-1);
        // }
        
        // System.out.println(dp1[n]+dp2[n]);
        
        System.out.println(pf(n,k));
    }
    
    public static int pf(int n, int k){
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }
        
        int ans = (pf(n-1,k)+pf(n-2,k)) * (k-1);
        return ans;
    }
}