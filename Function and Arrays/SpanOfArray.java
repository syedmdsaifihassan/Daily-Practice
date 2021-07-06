/*
Span Of Array

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.

Input Format
A number n
n1
n2
.. n number of elements

Output Format
A number representing max - min

Constraints
1 <= n <= 10^4
0 <= n1, n2
 .. n elements <= 10 ^9

Sample Input
6
15
30
40
4
11
9

Sample Output
36

*/

import java.io.*;
import java.util.*;

public class SpanOfArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    
    for(int i=0; i<n; i++){
        arr[i]=sc.nextInt();
    }
    
    int min=arr[0];
    for(int i=0; i<n; i++){
        if(min>arr[i]){
            min=arr[i];
        }
    }
    
    int max=arr[0];
    for(int i=0; i<n; i++){
        if(max<arr[i]){
            max=arr[i];
        }
    }
    int res = max-min;
    System.out.println(res);
 }

}