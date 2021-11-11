/*
Is A Power Of 2
Easy

1. You are given a number n.
2. You have to check whether it is a power of 2 or not.

Input Format
A number n
Output Format
true/false

Constraints
1 <= n <= 10^9

Sample Input
1024
Sample Output
true

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write your code here
        int csb = 0;
        while (n != 0) {
            n ^= n & (-n);
            csb++;
        }
        if (csb == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }

}