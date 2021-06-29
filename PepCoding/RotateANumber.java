/*
Rotate A Number

1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for negative value of k. Also k can have an absolute value larger than number of digits in n.
2. Take as input n and k.
3. Print the rotated number.
4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
   n = 12340056
   k = 3
   r = 05612340

Input Format
"n" where n is any integer.
"K" where k is any integer.

Output Format
"r", the rotated number

Constraints
1 <= n < 10^9
-10^9 < k < 10^9

Sample Input
562984
2

Sample Output
845629

*/

import java.util.*;
   
   public class RotateANumber {
   
   public static void main(String[] args) {
     // write your code here  
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int num = n;
     int k = sc.nextInt();
     int c=0;
     while(num!=0) {
         num=num/10;
         c++;
     }
     k=k%c;
     if(k<0) {
         k=k+c;
     }
     int d = (int)Math.pow(10,k);
     int m = (int)Math.pow(10, c-k);
     int q = n/d;
     int r = n%d;
     int res = (r*m)+q;
     System.out.println(res);
    }
   }

