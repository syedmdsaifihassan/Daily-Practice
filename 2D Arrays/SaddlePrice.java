/*
Saddle Price

1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix. 
2. You are required to find the saddle price of the given matrix and print the saddle price. 
3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.

Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements of array a

Output Format
Saddle point of the matrix if available or "Invalid input" if no saddle point is there.

Constraints
1 <= n <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9

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
41

*/

import java.io.*;
import java.util.*;

public class SaddlePrice {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j]=sc.nextInt();
            }
        }

        int ans=0;
        
        for(int i=0; i<n; i++){
            int min=mat[i][0], cmin=0;
            for(int j=0; j<n; j++){
                if(min>mat[i][j]){
                    min=mat[i][j];
                    cmin=j;
                }
            }
            int c=0;
            for(int j=0; j<n; j++){
                if(min<mat[j][cmin]){
                    c++;
                }
            }
            if(c==0){
                ans=min;
            }
        }
        
        if(ans==0){
            System.out.println("Invalid input");
        }else{
            System.out.println(ans);
        }
    }

}