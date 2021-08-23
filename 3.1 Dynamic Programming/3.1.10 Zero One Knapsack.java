/*
Zero One Knapsack
Easy
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.

Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap

Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity

Constraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10

Sample Input
5
15 14 10 45 30
2 5 1 3 4
7

Sample Output
75

Asked in Companies
VISA        1
Zoho        1
Snapdeal        1
MakeMyTrip      1

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] price = new int[n];
        for(int i=0; i<n; i++){
            price[i] = sc.nextInt();
        }
        
        int[] weight = new int[n];
        for(int i=0; i<n; i++){
            weight[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        
        System.out.println(zok(price, weight, cap));
    }
    
    public static int zok(int[] price, int[] weight, int cap){
        int[][] dp = new int[price.length+1][cap+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = dp[i-1][j];  //no
                if(j-weight[i-1]>=0){
                    dp[i][j] = Math.max(dp[i][j], price[i-1]+dp[i-1][j-weight[i-1]]);
                    
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}