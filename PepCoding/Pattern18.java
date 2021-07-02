/*
Pattern 18

1. You are given a number n.
2. You've to write code to print the pattern given in output format below

Input Format
A number n

Output Format
*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*

Constraints
1 <= n <= 10
 Also, n is odd.

Sample Input
7

Sample Output
*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*

*/

import java.util.*;

public class Pattern18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // write ur code here
        int n = sc.nextInt();
        int star = n;
        int space = 0; 
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=space; j++) {
                System.out.print("\t");
            }
            for(int j=star; j>=1; j--) {
                if(i>=2 && i<=n/2 && j>=2 && j<star) {
                    System.out.print("\t");
                }else {
                    System.out.print("*\t");
                }
            }
            if(i<=n/2) {
                space++;
                star-=2;
            }else {
                space--;
                star+=2;
            }
            System.out.println();
        }

    }
}