/*
Pattern 11

1. You are given a number n.
2. You've to create a pattern as shown in output format.

Input Format
A number n

Output Format
1	
2	3	
4	5	6	
7	8	9	10	
...

Constraints
1 <= n <= 44

Sample Input
5

Sample Output
1	
2	3	
4	5	6	
7	8	9	10	
11	12	13	14	15

*/

import java.util.*;

public class Pattern11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // write ur code here
        int n = sc.nextInt();
        int c=1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(c+"\t");
                c++;
            }
            System.out.println();
        }
    }
}