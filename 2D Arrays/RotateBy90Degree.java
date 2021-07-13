/*
Rotate By 90 Degree

1. You are given a number n, representing the number of rows and number of columns.
2. You are given n*n numbers, representing elements of 2d array a.
3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.

*Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*

Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements

Output Format
output is taken care of by display function

Constraints
1 <= n <= 10^2
-10^9 <= e1, e2, .. n * n elements <= 10^9

Sample Input
4
11
12
13
14
21
22
23
24
31
32
33
34
41
42
43
44

Sample Output
41 31 21 11
42 32 22 12
43 33 23 13
44 34 24 14

*/

import java.io.*;
import java.util.*;

public class RotateBy90Degree {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] mat = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        
        rotate(mat);
        display(mat);
    }
    
    public static void rotate(int[][] mat){
        
        // Transpose
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<i; j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
        // Arrange by swapping columns
        int l=0, r=mat[0].length-1;
        
        while(l<r){
            for(int i=0; i<mat.length; i++){
                int temp=mat[i][l];
                mat[i][l]=mat[i][r];
                mat[i][r]=temp;
            }
            l++;
            r--;
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}