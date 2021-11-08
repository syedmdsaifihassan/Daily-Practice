/*
Basics Of Bit Manipulation
Easy

1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.

Input Format
A number
Four numbers i,j,k,m.

Constraints
1 <= n <= 10^9
1 <= i <= 9
1 <= j <= 9
1 <= k <= 9
1 <= m <= 9

Sample Input
57
3 
3 
3 
3

Sample Output
57
49
49
true

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    System.out.println(n|1<<i);
    System.out.println(n&~(1<<j));
    System.out.println(n^1<<k);
    if((n&1<<m)==0){
        System.out.println(false);
    }else{
        System.out.println(true);
    }
  }

}