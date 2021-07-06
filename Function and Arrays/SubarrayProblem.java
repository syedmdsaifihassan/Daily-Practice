/*
Subarray Problem

1. You are given an array of size 'n' and n elements of the same array.
2. You are required to find and print all the subarrays of the given array. 
3. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.

Input Format
A number n
n1
n2
.. n number of elements

Output Format
[Tab separated elements of subarray]
..
All subarrays

Constraints
1 <= n <= 10
0 <= n1, n2
 .. n elements <= 10 ^9

Sample Input
3
10
20
30

Sample Output
10	
10	20	
10	20	30	
20	
20	30	
30	

*/

import java.io.*;
import java.util.*;

public class SubarrayProblem {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    
    for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();
    }
    
    for(int i=0; i<n; i++){
        for(int j=i; j<=n; j++){
            for(int k=i; k<j; k++){
                System.out.print(arr[k]+"\t");
                if(k==j-1){
                    System.out.println();
                }
            }
        }
    }
    
 }

}