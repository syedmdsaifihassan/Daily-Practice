/*
Arrange Buildings
Easy
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.

Input Format
A number n

Output Format
A number representing the number of ways in which the buildings can be built on both side of roads.

Constraints
0 < n <= 45

Sample Input
6

Sample Output
441

Asked in Companies
Payu        1

*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] dp1 = new long[n+1];   //ending at 0
    long[] dp2 = new long[n+1];   //ending at 1
    
    dp1[1] = 1;
    dp2[1] = 1;
    
    for(int i=2; i<dp1.length; i++){
        dp1[i] = dp2[i-1];
        dp2[i] = dp1[i-1]+dp2[i-1];
    }
    long total = dp1[n]+dp2[n];
    System.out.println(total*total);
 }

}