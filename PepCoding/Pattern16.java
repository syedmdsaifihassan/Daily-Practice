/*
Pattern 16

1. You are given a number n.
2. You've to write code to print the pattern given in output format below

Input Format
A number n

Output Format
1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1

Constraints
1 <= n <= 10

Sample Input
7

Sample Output
1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1

*/

import java.util.*;

public class Pattern16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // write ur code here
        int n = sc.nextInt();
        int space = (2*n)-3;
        int star = 1;
        int val=1;
        for(int i=1; i<=n; i++) {
            int val2=val;
            for(int j=1; j<=i; j++) {
                System.out.print(val2+"\t");
                val2++;
            }
            for(int j=space; j>0; j--) {
                System.out.print("\t");
            }
            val=val2;
            if(i==n) {
                star--;
                val=val2-1;
            }
            for(int j=1; j<=star; j++) {
                val--;
                System.out.print(val+"\t");
                
            }
            
            space -= 2;
            star ++;
            System.out.println();
        }

    }
}