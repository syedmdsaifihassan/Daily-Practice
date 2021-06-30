/*
Pattern 6

1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Input Format
A number n

Output Format
*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*

Constraints
1 <= n <= 100
 Also, n is odd.

Sample Input
5

Sample Output
*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*

*/

import java.util.*;

public class Pattern6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // write ur code here
    int n = sc.nextInt();
    int star = (n/2)+1;
    int space = 1;
    
    for (int i = 1; i <= n; i++) {
        
      for(int j=1; j<=star; j++) {
          System.out.print("*\t");
      }
      
      for(int j=1; j<=space; j++) {
          System.out.print("\t");
      }
      
      for(int j=1; j<=star; j++) {
          System.out.print("*\t");
      }
      
      if(i<=n/2) {
          star--;
          space += 2;
      }else {
          star++;
          space -= 2;
      }
      System.out.println();
    }

  }
}