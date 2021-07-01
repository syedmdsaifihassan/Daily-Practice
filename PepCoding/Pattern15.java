/*
Pattern 15

1. You are given a number n.
2. You've to write code to print the pattern given in output format below.

Input Format
A number n

Output Format
		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1

Constraints
1 <= n <= 10
 Also, n is odd.

Sample Input
5

Sample Output
		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1

*/

import java.util.*;

public class Pattern15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // write ur code here
        int n = sc.nextInt();
        int space = n/2;
        int star = 1;
        int val=1;
        
        for(int i=1; i<=n; i++) {
            int val2=val;
            for(int j=space; j>=1; j--) {
                System.out.print("\t");
            }
            for(int j=1; j<=star; j++) {
                System.out.print(val2+"\t");
                if(j<=star/2) {
                    val2++;
                }else {
                    val2--;
                }
            }
            System.out.println();
            if(i<=n/2) {
                space--;
                star += 2;
                val++;
            }else {
                space++;
                star -= 2;
                val--;
            }
        }

    }
}