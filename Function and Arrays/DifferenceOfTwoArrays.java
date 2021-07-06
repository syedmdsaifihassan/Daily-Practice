/*
Difference Of Two Arrays

1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to find the difference of two numbers represented by two arrays and print the arrays. a2 - a1

Assumption - number represented by a2 is greater.

Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated

Output Format
A number representing difference of two numbers (a2 - a1), represented by two arrays.

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
number reresented by a1 is smaller than number represented by a2

Sample Input
3
2
6
7
4
1
0
0
0

Sample Output
7
3
3

*/

import java.io.*;
import java.util.*;

public class DifferenceOfTwoArrays {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++){
        arr1[i] = sc.nextInt();
    }
    
    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++){
        arr2[i] = sc.nextInt();
    }
    
    int n3;
    if(n1>=n2){
        n3 = n1;
    }else{
        n3 = n2;
    }
    int[] res = new int[n3];
    
    int i=n1-1, j=n2-1, k=n3-1, b=0;
    while(k >= 0){
        int diff = arr2[j] - b;
        if(i>=0){
            diff -= arr1[i];
        }
        if(diff<0){
            b=1;
            diff+=10;
        }else{
            b=0;
        }
        
        res[k]=diff;
        i--;
        j--;
        k--;
    }
    
    for(i=0; i<res.length; i++){
        int l=0;
        if(i==l && res[i]==0){
            l++;
        }else{
            System.out.println(res[i]);   
        }
    }
 }

}