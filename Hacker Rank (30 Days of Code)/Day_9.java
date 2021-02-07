//RECURSION 3

/*
Objective
Today, we are learning about an algorithmic concept called recursion.

Recursive Method for Calculating Factorial
factorial(N)=   |1                      N<=1
                |N * factorial(N-1)     otherwise



Function Description
Complete the factorial function in the editor below. Be sure to use recursion.
factorial has the following paramter:
int n: an integer

Returns
int: the factorial of n

Note: If you fail to use recursion or fail to name your recursive function factorial or Factorial, you will get a score of 0.

Input Format

A single integer, n (the argument to pass to factorial).

Constraints
2<=n<=12


Your submission must contain a recursive function named factorial.

Sample Input
3

Sample Output
6

Explanation

Consider the following steps. After the recursive calls from step 1 to 3, results are accumulated from step 3 to 1.

1. factorial(3)= 3*factorial(2)= 3*2= 6
2. factorial(2)= 2*factorial(2)= 2*1= 2
3. factorial(1)= 1

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext())
        {
            int n = in.nextInt();
            int m=factorial(n);
            System.out.println(m);
        }    
    }
    
    public static int factorial(int n)
        {
        if(n==0||n==1)
            return 1;
        else
            return n*factorial(n-1);
    }
}
