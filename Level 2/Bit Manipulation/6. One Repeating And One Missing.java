/*
One Repeating And One Missing
Easy

1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.

Input Format
A number n
a1
a2..
n numbers

Output Format
Missing number
Repeating Number

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 

Sample Input
7
1 
3 
4 
5 
1 
6 
2

Sample Output
Missing Number -> 7
Repeating Number -> 1

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
      int xor = 0;
      for(int i=0; i<arr.length; i++){
          xor = xor^arr[i];
          xor = xor^(i+1);
      }
      
      int rsb = (xor&(-xor));
      int n1 = 0;
      int n2 = 0;
      for(int i=0; i<arr.length; i++){
          if((rsb&(arr[i]))==0){
              n1 = n1^arr[i];
          }else{
              n2 = n2^arr[i];
          }
          
          if((rsb&(i+1))==0){
              n1 = n1^(i+1);
          }else{
              n2 = n2^(i+1);
          }
      }
      
      for(int i=0; i<arr.length; i++){
          if(n1 == arr[i]){
              System.out.println("Missing Number -> "+(n2));
              System.out.println("Repeating Number -> "+(n1));
              break;
          }
          if(n2 == arr[i]){
              System.out.println("Missing Number -> "+(n1));
              System.out.println("Repeating Number -> "+(n2));
              break;
          }
      }
      
  }

}