/*
Gcd And Lcm

1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
3. Take input "num1" and "num2" as the two numbers.
4. Print their GCD and LCM.

Input Format
num1
num2
.. the numbers whose GCD and LCM we have to find.

Output Format
a
b
.. where 'a' and 'b' are the GCD and LCM respectively.

Constraints
2 <= n <= 10^9

Sample Input
36
24

Sample Output
12
72

*/

import java.util.*;
    
    public class GcdAndLcm {
    
    public static void main(String[] args) {
      // write your code here  
      Scanner sc = new Scanner(System.in);
      int num1 = sc. nextInt();
      int num2 = sc.nextInt();
      int a=num1, b=num2;
      while(num1!=num2) {
          if(num1>num2) {
              num1-=num2;
          } else{
              num2-=num1;
          }
      }
      int gcd = num1;
      int lcm = (a*b)/gcd;
      System.out.println(gcd);
      System.out.println(lcm);
     }
    }