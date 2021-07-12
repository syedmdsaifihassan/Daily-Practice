/*
Spiral Display

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a.
4. You are required to traverse and print the contents of the 2d array in form of a spiral.
Note - Please check the sample output for details.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
e11
e21
..
en1
en2
en3
..
enm
e(n-1)m
..
e1m
e1(m-1)
..
e12
e22
e32
..

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
-10^9 <= e1, e2, .. n * m elements <= 10^9

Sample Input
3
5
11
12
13
14
15
21
22
23
24
25
31
32
33
34
35

Sample Output
11
21
31
32
33
34
35
25
15
14
13
12
22
23
24

*/

import java.io.*;
import java.util.*;

public class SpiralDisplay {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int rmin=0, rmax=m-1, cmin=0, cmax=n-1, count=0;
        
        while(count<n*m){
            
            //left
            for(int i=rmin; i<=rmax && count<n*m; i++){
                System.out.println(arr[i][cmin]);
                count++;
            }
            cmin++;
            
            //bottom
            for(int j=cmin; j<=cmax && count<n*m; j++){
                System.out.println(arr[rmax][j]);
                count++;
            }
            rmax--;
            
            //right
            for(int i=rmax; i>=rmin && count<n*m; i--){
                System.out.println(arr[i][cmax]);
                count++;
            }
            cmax--;
            
            //top
            for(int j=cmax; j>=cmin && count<n*m; j--){
                System.out.println(arr[rmin][j]);
                count++;
            }
            rmin++;

        }
        
        
    }

}