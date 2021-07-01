/*
Pattern 7

1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Input Format
A number n

Output Format
*	
	*	
		*	
			*	
				*

Constraints
1 <= n <= 100

Sample Input
5

Sample Output
*	
	*	
		*	
			*	
				*

*/

import java.util.*;

public class Pattern7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // write ur code here
        int n = sc.nextInt();
        int space = 0;
        int star = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=space; j<i; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            System.out.println();
        }

    }
}