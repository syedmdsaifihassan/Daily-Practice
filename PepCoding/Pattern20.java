/*
Pattern 20

1. You are given a number n.
2. You've to write code to print the pattern given in output format below.

Input Format
A number n

Output Format
*				*	
*				*	
*		*		*	
*	*		*	*	
*				*

Constraints
1 <= n <= 10
 Also, n is odd.

Sample Input
5

Sample Output
*				*	
*				*	
*		*		*	
*	*		*	*	
*				*

*/

import java.util.*;

public class Pattern20 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // write ur code here
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i <= n / 2) {
          if (j == 1 || j == n) {
            System.out.print("*\t");
          } else {
            System.out.print("\t");
          }
        } else if (i > n / 2 || i == n) {
          if (j == 1 || j == n || i == j || i + j - 1 == n) {
            System.out.print("*\t");
          } else {
            System.out.print("\t");
          }
        } else if (i == n) {
          if (j == 1 || j == n) {
            System.out.print("*\t");
          } else {
            System.out.print("\t");
          }
        }
      }
      System.out.println();
    }
  }
}