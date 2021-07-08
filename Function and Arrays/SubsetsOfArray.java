/*
Subsets Of Array

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to print all subsets of arr. Each subset should be
on separate line. For more clarity check out sample input and output.

Input Format
A number n
n1
n2
.. n number of elements

Output Format
[Tab separated elements of subset]
..
All subsets

Constraints
1 <= n <= 10
0 <= n1, n2, .. n elements <= 10^3

Sample Input
3
10
20
30

Sample Output
-	-	-	
-	-	30	
-	20	-	
-	20	30	
10	-	-	
10	-	30	
10	20	-	
10	20	30	

*/

import java.io.*;
import java.util.*;

public class SubsetsOfArray {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int t = (int)Math.pow(2,n);
    
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < t; i++) {
        
      int bn = decToBin(i);
      int p=(int)Math.pow(10, n-1);
      
      for (int j=0; j<n; j++) {
        int q = bn / p;
        int r = bn % p;
        if (q == 1) {
          System.out.print(arr[j] + "\t");
        } else {
          System.out.print("-\t");
        }
        p/=10;
        bn = r;
      }
      System.out.println();
    }
  }
  public static int decToBin(int n) {
    // write code here
    int ans = 0, p = 0;
    while (n != 0) {
      int r = n % 2;
      n = n / 2;
      ans += r * Math.pow(10, p);
      p++;
    }
    return ans;
  }

}