/*
Sort 012
Easy

1. You are given an array(arr) containing only 0's, 1's, and 2's.
2. You have to sort the given array in increasing order and in linear time.

Input Format
An Integer N 
arr1
arr2..
n integers

Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10000
arr[i] = 0,1,2

Sample Input
10
1
0
2
2
1
0
2
1
0
2

Sample Output
Swapping index 1 and index 0
Swapping index 2 and index 9
Swapping index 2 and index 8
Swapping index 2 and index 1
Swapping index 3 and index 7
Swapping index 5 and index 2
Swapping index 6 and index 6
0
0
0
1
1
1
2
2
2
2


Asked in Companies
Microsoft       1
Adobe       1
Amazon      1
Walmart     1
Sap labs        1
Qualcomm        1
Morgan Stanley      1
Paytm       1
MAQ Software        1
Snapdeal        1
Yatra       1
MakeMyTrip      1
Hike        1
Ola Cabs        1

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void sort012(int[] arr){
    //write your code here
    int i=0, j=0, k=arr.length-1;
    while(i<=k){
        if(arr[i]==0){
            swap(arr, i, j);
            i++;
            j++;
        }else if(arr[i]==1){
            i++;
        }else if(arr[i]==2){
            swap(arr, i, k);
            k--;
        }
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort012(arr);
    print(arr);
  }

}