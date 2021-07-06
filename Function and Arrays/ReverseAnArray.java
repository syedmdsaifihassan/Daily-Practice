/*
Reverse An Array

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to reverse the contents of array a.

Input Format
Input is managed for you

Output Format
Output is managed for you

Constraints
0 <= n < 10^4
-10^9 <= a[i] <= 10^9

Sample Input
5
1
2
3
4
5

Sample Output
5 4 3 2 1

*/

import java.io.*;
import java.util.*;

public class ReverseAnArray {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i]=sc.nextInt();
    }

    // int[] res = new int[n];
    // for(int i=0; i<n; i++){
    //     res[i]=arr[n-i-1];
    //     System.out.print(res[i]+" ");
    // }
    
    int left=0, right=n-1;
    while(left<right){
        int temp;
        temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        left++;
        right--;
    }
    for(int i=0; i<n; i++){
        System.out.print(arr[i]+" ");
    }
    
 }

}