/*
Print Value Of Rsb Mask
Easy

1. You are given a number n.
2. You have to print the right-most set bit mask.

Constraints
1 <= n <= 10^9

Sample Input
58
Sample Output
10

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //write your code here
    int resInt = n&((~n)+1);
    // int resInt = n&(-n);
    System.out.println(Integer.toBinaryString(resInt));
  }

}