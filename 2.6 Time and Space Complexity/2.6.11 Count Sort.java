/*
Count Sort
Easy
1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using count sort.

Input Format
An Integer n 
arr1
arr2..
n integers

Output Format
Check the sample ouput and question video.

Question Video

  COMMENT
  Constraints
1 <= N <= 10000
-10^8 <= arr[i] <= 10^8

Sample Input
5
7 
-2 
4 
1 
3

Sample Output
-2
1
3
4
7


Asked in Companies
Samsung     1
Snapdeal        1

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
    int n = max - min + 1;
    int[] freq = new int[n];
    Arrays.fill(freq, 0);
    
    //frequency array
    for(int i=0; i<arr.length; i++){
        int c = arr[i]-min;
        freq[c]++;
    }
    
    //prefix sum array
    int[] pfreq = new int[n];
    pfreq[0] = freq[0];
    for(int i=1; i<pfreq.length; i++){
        pfreq[i] = pfreq[i-1]+freq[i];
    }
    
    //answer array
    int[] ans = new int[arr.length];
    for(int i=arr.length-1; i>=0; i--){
        int c = arr[i]-min;
        int pos = pfreq[c];
        ans[pos-1] = arr[i];
        pfreq[c]--;
    }
    for(int i=0; i<arr.length; i++){
        arr[i] = ans[i];
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}