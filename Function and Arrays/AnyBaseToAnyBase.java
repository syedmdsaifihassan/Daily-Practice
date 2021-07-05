/*
Any Base To Any Base

1. You are given a number n.
2. You are given a base b1. n is a number on base b.
3. You are given another base b2.
4. You are required to convert the number n of base b1 to a number in base b2.

Input Format
A number n
A base b1
A base b2

Output Format
A number of base b2 equal in value to n of base b1.

Constraints
0 <= n <= 512
2 <= b1 <= 10
2 <= b2 <= 10

Sample Input
111001
2
3

Sample Output
2010

*/

import java.util.*;
  
  public class AnyBaseToAnyBase{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b1 = scn.nextInt();
      int b2 = scn.nextInt();
      
      int decno = btod(n,b1);
      int ans = dtob(decno,b2);
      System.out.println(ans);
   }   
   
   public static int btod(int n, int b){
      // write your code here
      int ans=0,p=0;
      while(n!=0){
          int r=n%10;
          ans += r*Math.pow(b,p);
          p++;
          n=n/10;
      }
      return ans;
   }
   public static int dtob(int n, int b){
       // write code here
       int ans=0,p=0;
       while(n!=0){
           int r=n%b;
           n=n/b;
           ans += r*Math.pow(10,p);
           p++;
       }
       return ans;
   }
  }