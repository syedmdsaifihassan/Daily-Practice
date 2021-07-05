/*
Any Base Addition

1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to add the two numbes and print their value in base b.

Input Format
A base b
A number n1
A number n2

Output Format
A number representing the sum of n1 and n2 in base b.

Constraints
2 <= b <= 10
0 <= n1 <= 256
0 <= n2 <= 256

Sample Input
8
777
1

Sample Output
1000

*/

import java.util.*;
  
  public class AnyBaseAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int ans=0, carry=0,p=0;
       while(n1!=0 || n2!=0 || carry!=0){
           //find last digit of n1 and n2
           int sum=0;
           sum += (n1%10) + (n2%10) + carry;
           
           //find q and r
           int r=sum%b;
           int q=sum/b;
           
           //update ans with the help of r
           ans += r*Math.pow(10,p);
           p++;
           
           //update carry with the help of q
           carry=q;
           
           //update n1 and n2
           n1=n1/10;
           n2=n2/10;
           
           
       }
       return ans;
   }
  }