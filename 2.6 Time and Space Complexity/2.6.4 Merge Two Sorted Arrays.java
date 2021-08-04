/*
Merge Two Sorted Arrays
Easy

1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.

Input Format
An Integer n 
a1
a2..n integers
An integer m
b1
b2..m integers

Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10^8
-10^9 <= a[i],b[i] <= 10^9

Sample Input
4
-2 
5 
9 
11
3
4 
6 
8

Sample Output
-2
4
5
6
8
9
11

Asked in Companies
Microsoft   1
Amazon  1
Goldman Sachs   1
LinkedIn    1
VISA    1
Zoho    1
Snapdeal    1
Amdocs  1

*/

import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here
    int n = a.length;
    int m = b.length;
    int ans = n + m;
    int[] res = new int[ans];
    int i=0, j=0, k=0;
    while(i<n && j<m){
        if(a[i]<b[j]){
            res[k]=a[i];
            i++;
            k++;
        }else{
            res[k]=b[j];
            j++;
            k++;
        }
    }
    while(i<n){
        res[k]=a[i];
        i++;
        k++;
    }
    while(j<m){
        res[k]=b[j];
        j++;
        k++;
    }
    
    return res;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}