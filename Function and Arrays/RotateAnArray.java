/*
Rotate An Array

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. Rotate the array a, k times to the right (for positive values of k), and to
the left for negative values of k.

Input Format
Input is managed for you

Output Format
Output is managed for you

Constraints
0 <= n < 10^4
-10^9 <= a[i], k <= 10^9

Sample Input
5
1
2
3
4
5
3

Sample Output
3 4 5 1 2

*/

import java.io.*;
import java.util.*;

public class RotateAnArray {
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k){
    k = k%a.length;
    if(k<0){
        k+=a.length;
    }
    // write your code here
    reverse(a, 0, a.length-1);
    reverse(a, 0, k-1);
    reverse(a, k, a.length-1);
  }
  
  public static void reverse(int[] a, int left, int right){
      while(left<right){
        int temp;
        temp=a[left];
        a[left]=a[right];
        a[right]=temp;
        left++;
        right--;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}