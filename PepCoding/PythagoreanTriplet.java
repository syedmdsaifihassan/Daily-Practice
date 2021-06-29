/*
Pythagorean Triplet

1. You are required to check if a given set of numbers is a valid pythagorean triplet.
2. Take as input three numbers a, b and c.
3. Print true if they can form a pythagorean triplet and false otherwise.

Input Format
a, an integer
b, an integer
c, an integer

Output Format
true if the numbers form a pythagorean triplet and false otherwise

Constraints
1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9

Sample Input
5 3 4

Sample Output
true

*/

import java.util.*;
  
  public class PythagoreanTriplet {
  
  public static void main(String[] args) {
    // write your code here  
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int m;
    boolean result=false;
    if(a>b && a>c) {
        m=a;
    }else if(b>c) {
        m=b;
    }else {
        m=c;
    }
    
    if(m*m == a*a+b*b+c*c-m*m) {
        result=true;
    }
    System.out.println(result);
   }
  }