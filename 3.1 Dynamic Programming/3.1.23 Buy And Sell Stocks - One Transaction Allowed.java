/*
Buy And Sell Stocks - One Transaction Allowed

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.

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
17

Asked in Companies
Microsoft       8
Google      4
Amazon      36
Goldman Sachs       5
Oracle      3
Facebook        20
Apple       7
Bloomberg       7
ByteDance       3
Audible     2

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] prices = new int[n];
        for(int i=0; i<prices.length; i++){
            prices[i] = sc.nextInt();
        }
        int lsf = Integer.MAX_VALUE;
        int p = 0;
        int pt = 0;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i]<lsf){
                lsf = prices[i];
            }
            
            pt = prices[i]-lsf;
            if(pt>p){
                p = pt;
            }
        }
        
        System.out.println(p);
    }

}