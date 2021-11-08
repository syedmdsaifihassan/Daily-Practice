/*
Kernighans Algorithm
Easy

1. You are given a number n.
2. You have to count the number of set bits in the given number.

Constraints
1 <= n <= 10^9

Sample Input
58
Sample Output
4

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int itr = 0;
    while(n!=0){
        n ^= n&(-n);
        itr++;
    }
    System.out.println(itr);
  }

}