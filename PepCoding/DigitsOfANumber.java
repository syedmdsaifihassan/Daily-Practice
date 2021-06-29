/*
Digits Of A Number

1. You've to display the digits of a number.
2. Take as input "n", the number for which digits have to be displayed.
3. Print the digits of the number line-wise.

Input Format
"n" where n is any integer.

Output Format
d1
d2
d3
... digits of the number

Constraints
1 <= n < 10^9

Sample Input
65784383

Sample Output
6
5
7
8
4
3
8
3

*/

import java.util.*;
    
    public class DigitsOfANumber {
    
    public static void main(String[] args) {
      // write your code here  
      Scanner sc = new Scanner(System.in);
      int n=sc.nextInt();
      int n1=n;
      int c=0;
      while(n1!=0) {
         n1=n1/10;
         c++;
      }
      c=c-1;
      int d = (int)Math.pow(10,c);
      
      while(d!=0) {
          int q = n/d;
          int r = n%d;
          System.out.println(q);
          n=r;
          d=d/10;
      }
     }
    }
