/*
Any Base Subtraction

1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to subtract n1 from n2 and print the value.

Input Format
A base b
A number n1
A number n2

Output Format
A number of base b equal in value to n2 - n1.

Constraints
2 <= b <= 10
0 <= n1 <= 256
n1 <= n2 <= 256

Sample Input
8
1
100

Sample Output
77

*/

import java.util.*;
  
  public class AnyBaseSubtraction{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int ans = 0, p = 0, c = 0;
       
       while(n2!=0){
           int l1 = n1%10;
           int l2 = n2%10;
           n1=n1/10;
           n2=n2/10;
           int d = 0;
           l2=l2+c;
           
           if(l2>=l1){
               c=0;
               d=l2-l1;
           }else{
               c=-1;
               d=l2+b-l1;
           }
           ans+=d*Math.pow(10,p);
           p++;
       }
       return ans;
       
   }
  
  }