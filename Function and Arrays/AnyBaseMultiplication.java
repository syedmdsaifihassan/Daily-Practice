/*
Any Base Multiplication

1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to multiply n1 and n2 and print the value.

Input Format
A base b
A number n1
A number n2

Output Format
A number of base b equal in value to n2 * n1.

Constraints
2 <= b <= 10
0 <= n1 <= 10000
0 <= n2 <= 10000

Sample Input
5
1220
31

Sample Output
43320

*/

import java.util.*;

public class AnyBaseMultiplication {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
  }

  public static int getProduct(int b, int n1, int n2) {
    // write your code here
    int ans=0, p=0;
    while(n2!=0){
        int l2 = n2%10;
        n2 = n2/10;
        int pwsd = gpwsd(n1, l2, b);
        ans = aba(ans, pwsd*(int)Math.pow(10,p), b);
        p++;
    }
    return ans;
  }
  
  public static int gpwsd(int n1, int n2, int b) {
    int ans=0, carry=0,p=0;
       while(n1!=0 || carry!=0){
           //find last digit of n1 only because n2 is single digit no.
           int mul = ((n1%10) * n2) + carry;
           
           //find q and r
           int r=mul%b;
           int q=mul/b;
           
           //update ans with the help of r
           ans += r*Math.pow(10,p);
           p++;
           
           //update carry with the help of q
           carry=q;
           
           //update n1 only because n2 is a single digit no. here
           n1=n1/10;
       }
       return ans;
  }
  
  public static int aba(int n1, int n2, int b) {
    int ans=0, carry=0,p=0;
       while(n1!=0 || n2!=0 || carry!=0){
           //find last digit of n1 and n2
           int sum = (n1%10) + (n2%10) + carry;
           
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