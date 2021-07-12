/*
Ring Rotate

You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
You will be given a ring number 's' representing the ring of the matrix.

You will be given a number 'r' representing number of rotations in an anti-clockwise manner of the specified ring.
You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix.

Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements of array a
A number s
A number r

Output Format
output is handled by display function

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9
0 < s <= min(n, m) / 2
-10^9 <= r <= 10^9

Sample Input
5
7
11
12
13
14
15
16
17
21
22
23
24
25
26
27
31
32
33
34
35
36
37
41
42
43
44
45
46
47
51
52
53
54
55
56
57
2
3

Sample Output
11 12 13 14 15 16 17
21 25 26 36 46 45 27
31 24 33 34 35 44 37
41 23 22 32 42 43 47
51 52 53 54 55 56 57

*/

import java.io.*;
import java.util.*;

public class RingRotate {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc. nextInt();
        int[][] array = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                array[i][j]=sc.nextInt();
            }
        }
        int shell = sc.nextInt();
        int rot = sc.nextInt();
        ringRotate(array, shell, rot);
        display(array);
    }
    
    public static void ringRotate(int[][]arr, int s, int r){
        int[] la = fill1D(arr, s);
        rotate(la, r);
        fill2D(arr, la, s);
    }
    
    public static int[] fill1D(int[][] arr, int s){
        
        int rmin=s-1, rmax=arr.length-s, cmin=s-1, cmax=arr[0].length-s, count=0;
        int size = 2*(rmax+cmax-rmin-cmin);
        int[] temp = new int[size];
        
        while(count<size){
            
            //left
            for(int i=rmin; i<=rmax && count<size; i++){
                temp[count]=arr[i][cmin];
                count++;
            }
            cmin++;
            
            //bottom
            for(int j=cmin; j<=cmax && count<size; j++){
                temp[count]=arr[rmax][j];
                count++;
            }
            rmax--;
            
            //right
            for(int i=rmax; i>=rmin && count<size; i--){
                temp[count]=arr[i][cmax];
                count++;
            }
            cmax--;
            
            //top
            for(int j=cmax; j>=cmin && count<size; j--){
                temp[count]=arr[rmin][j];
                count++;
            }
            rmin++;

        }
        return temp;
    }
    
    public static void rotate(int[] la, int r){
        r = r%la.length;
        if(r<0){
            r+=la.length;
        }
        reverse(la, 0, la.length-1);
        reverse(la, 0, r-1);
        reverse(la, r, la.length-1);
    }
    public static void reverse(int[] la, int left, int right){
        while(left<right){
            int temp;
            temp=la[left];
            la[left]=la[right];
            la[right]=temp;
            left++;
            right--;
        }
    }
    
    public static void fill2D(int[][] arr, int[] la, int s){

        int rmin=s-1, rmax=arr.length-s, cmin=s-1, cmax=arr[0].length-s, count=0;
        int size = 2*(rmax+cmax-rmin-cmin);
        
        while(count<size){
            
            //left
            for(int i=rmin; i<=rmax && count<size; i++){
                arr[i][cmin]=la[count];
                count++;
            }
            cmin++;
            
            //bottom
            for(int j=cmin; j<=cmax && count<size; j++){
                arr[rmax][j]=la[count];
                count++;
            }
            rmax--;
            
            //right
            for(int i=rmax; i>=rmin && count<size; i--){
                arr[i][cmax]=la[count];
                count++;
            }
            cmax--;
            
            //top
            for(int j=cmax; j>=cmin && count<size; j--){
                arr[rmin][j]=la[count];
                count++;
            }
            rmin++;

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