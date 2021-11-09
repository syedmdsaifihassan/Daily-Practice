/*
All Repeating Except Two
Easy

1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.

Input Format
A number n
a1
a2..
n numbers

Output Format
2 Non-repeating number

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
6

23 27 23 17 17 37
Sample Output
27
37

*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
    //write your code here
    int ans = 0;
    for(int i=0; i<arr.length; i++){
       ans = arr[i]^ans;
    }
    
    int rsb = ans&(-ans);
    int n1 = 0;
    int n2 = 0;
    // dividing into two sets
    for(int i=0; i<arr.length; i++){
        if((arr[i]&rsb)==rsb){
            n1 = n1^arr[i];
        }else{
            n2 = n2^arr[i];
        }
    }
    
    if(n1<n2){
        System.out.println(n1);
        System.out.println(n2);
    }else{
        System.out.println(n2);
        System.out.println(n1);
    }
    
  }

}