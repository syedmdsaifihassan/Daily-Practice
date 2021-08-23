/*
Maximum Sum Non Adjacent Elements
Easy
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.

Input Format
A number n
n1
n2
.. n number of elements

Output Format
A number representing the maximum sum of a subsequence with no adjacent elements.

Constraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000

Sample Input
6
5
10
10
100
5
6

Sample Output
116


Asked in Companies
Google      5
Amazon      3
Walmart     1
Paytm       1
OYO Rooms       1
Yahoo       1
Accolite        1
Oxigen Wallet       1

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int inc = arr[0];
        int exc = 0;
        
        for(int i=1; i<arr.length; i++){
            int inc1 = exc + arr[i];
            int exc1 = Math.max(inc, exc);
            inc = inc1;
            exc = exc1;
        }
        
        int ans = Math.max(inc, exc);
        System.out.println(ans);
    }
}