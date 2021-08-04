/*
Insertion Sort
Easy

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using insertion sort.

Input Format
An Integer n 
arr1
arr2..
n integers

Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10000
-10^9 <= arr[i] <= 10^9

Sample Input
5
7 
-2 
4 
1 
3

Sample Output
Comparing -2 and 7
Swapping 7 and -2
Comparing 4 and 7
Swapping 7 and 4
Comparing 4 and -2
Comparing 1 and 7
Swapping 7 and 1
Comparing 1 and 4
Swapping 4 and 1
Comparing 1 and -2
Comparing 3 and 7
Swapping 7 and 3
Comparing 3 and 4
Swapping 4 and 3
Comparing 3 and 1
-2
1
3
4
7

Asked in Companies
cisco   1
Dell    1
MAQ Software    1
Accenture   1
Juniper Networks    1
Grofers 1
Veritas 1

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void insertionSort(int[] arr) {
    //write your code here
    for(int i=1; i<arr.length; i++){
        for(int j=i; j>0; j--){
            if(isGreater(arr, j-1, j)==true){
                swap(arr, j-1, j);
            }else{
                break;
            }
        }
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if jth element is greater than ith element
  public static boolean isGreater(int[] arr, int j, int i) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    insertionSort(arr);
    print(arr);
  }

}