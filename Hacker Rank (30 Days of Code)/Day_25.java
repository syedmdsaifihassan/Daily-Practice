//Running Time and Complexity

/*
Objective
Today we will learn about running time, also known as time complexity.

Task
A prime is a natural number greater than 1 that has no positive divisors other than  and itself. Given a number, n, determine and print whether it is Prime or Not prime.

Note: If possible, try to come up with a O(n^1/2) primality algorithm, or see what sort of optimizations you come up with for an O(n) algorithm. Be sure to check out the Editorial after submitting your code.

Input Format

The first line contains an integer, T, the number of test cases.
Each of the T subsequent lines contains an integer, n, to be tested for primality.

Constraints
1 <= T <= 30
1 <= n <= 2*10^9

Output Format

For each test case, print whether n is Prime or Not prime on a new line.

Sample Input

3
12
5
7

Sample Output

Not prime
Prime
Prime

Explanation

Test Case 0: n=12.
12 is divisible by numbers other than 1 and itself (i.e.: 2, 3, 4, 6), so we print Not prime on a new line.

Test Case 1: n=5.
5 is only divisible 1 and itself, so we print Prime on a new line.

Test Case 2: n=7.
7 is only divisible 1 and itself, so we print Prime on a new line.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=0; i<T; i++) {
            int n=in.nextInt();
            int count=0;          
            if(n==1)
                System.out.println("Not prime");
            else {    
                for(int j=2; j*j<=n; j++) {
                    if(n%j==0)
                        count++;
                }
                if(count==0)
                    System.out.println("Prime");
                else
                    System.out.println("Not prime");
            }
        }
    }
}



