//BINARY NUMBERS

/*
Objective
Today, we're working with binary numbers.

Task
Given a base- 10integer, n, convert it to binary (base-2). Then find and print the base- 10integer denoting the maximum number of consecutive 1's in n's binary representation. When working with different bases, it is common to show the base as a subscript.

Example
n=125

The binary representation of 125(10) is 1111101(2). In base 10, there are 5 and 1 consecutive ones in two groups. Print the maximum, .

Input Format

A single integer, n.

Constraints
1<=n<=10^6

Output Format

Print a single base- 10integer that denotes the maximum number of consecutive 1's in the binary representation of n.

Sample Input 1
5

Sample Output 1
1

Sample Input 2
13

Sample Output 2
2

Explanation

Sample Case 1:
The binary representation of 5(10) is 101(2), so the maximum number of consecutive 1's is 1.

Sample Case 2:
The binary representation of 13(10) is 1101(2), so the maximum number of consecutive 1's is 2.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        
        int count=0,min=0;
        while(n>0)
        {
            if(n%2==1)
            {    
                count++; 
                if(count>=min)
                {
                    min=count;
                }
            }
            else
            {
                count=0;
            }
            n=n/2;
        }
        System.out.println(min);
    }
}
