/*
Sum Of Two Arrays

1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to add the numbers represented by two arrays and print the
arrays.

Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated

Output Format
A number representing sum of two numbers, represented by two arrays.

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10

Sample Input
5
3
1
0
7
5
6
1
1
1
1
1
1

Sample Output
1
4
2
1
8
6

*/

import java.io.*;
import java.util.*;

public class SumOfTwoArrays {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++){
        arr1[i]=sc.nextInt();
    }
    
    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++){
        arr2[i]=sc.nextInt();
    }
    
    int n3,c=0;
    
    if(n1>=n2){
        n3=n1+1;
    }else{
        n3=n2+1;
    }
    
    int[] res = new int[n3];
    int i=n1-1, j=n2-1, k=n3-1;
    while(k>=0){
        int sum=c;
        if(i>=0){
            sum+=arr1[i];
        }
        if(j>=0){
            sum+=arr2[j];
        }
        
        if(sum>=10){
            c=1;
            sum-=10;
        }else{
            c=0;
        }
        res[k]=sum;
        i--;
        j--;
        k--;
    }
    
    for(i=0; i<res.length; i++){
        if(i==0 && res[0]==0){
            
        }else{
            System.out.println(res[i]);   
        }
    }
    
 }

}