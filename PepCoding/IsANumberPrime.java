/*
Is A Number Prime
Easy
1. You've to check whether a given number is prime or not.
2. Take a number "t" as input representing count of input numbers to be tested.
3. Take a number "n" as input "t" number of times.
4. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.\

Input Format
A number t
A number n
A number n
.. t number of times

Output Format
prime
not prime
not prime
.. t number of times

*/

import java.util.*;
  
  public class IsANumberPrime{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
        // write ur code here
        int t = scn.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int c=0;
            if(n==1) {
                c=0;
            }
            for(int j = 2; j*j <= n; j++) {
                if(n%j==0) {
                    c++;
                    break;
                }
            }
            if(c==0) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
  
   }
  }