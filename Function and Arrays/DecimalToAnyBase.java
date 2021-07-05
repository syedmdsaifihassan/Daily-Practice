/*
Decimal To Any Base

1. You are given a decimal number n.
2. You are given a base b.
3. You are required to convert the number n into its corresponding value in base b.

Input Format
A number n
A base b

Output Format
A number representing corresponding value of n in number system of base b

Constraints
0 <= d <= 512
2 <= b <= 10

Sample Input
57
2

Sample Output
111001

*/

import java.util.*;
  
  public class DecimalToAnyBase{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
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