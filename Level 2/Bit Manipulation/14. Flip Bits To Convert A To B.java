/*
Flip Bits To Convert A To B
Easy

1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.

Input Format
2 numbers A and B

Output Format
A number

Constraints
-10^9 <= A,B <= 10^9
Sample Input
57
76
Sample Output
5

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();

    //write your code here
    int xor = a^b;
    int csb = 0;
    while(xor!=0){
        xor ^= xor&(-xor);
        csb++;
    }
    
    System.out.println(csb);
  }

}