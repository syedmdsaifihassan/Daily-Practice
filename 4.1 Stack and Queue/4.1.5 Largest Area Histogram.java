/*
Largest Area Histogram
Hard

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12

Constraints
0 <= n < 20
0 <= a[i] <= 10

Sample Input
7
6
2
5
4
5
1
6

Sample Output
12


Asked in Companies
Google      4
Amazon      8
Bloomberg       3

*/

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    
    Stack<Integer> st = new Stack<>();
    // left idx
    int[] nsl = new int[n];
    for(int i=0; i<n; i++){
        while(st.size()>0 && a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.size()==0){
            nsl[i] = -1;
        }else{
            nsl[i] = st.peek();
        }
        st.push(i);
    }
    // right idx
    int[] nsr = new int[n];
    for(int i=n-1; i>=0; i--){
        while(st.size()>0 && a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.size()==0){
            nsr[i] = a.length;
        }else{
            nsr[i] = st.peek();
        }
        st.push(i);
    }
    // calculating areas array
    int maxArea = 0;
    for(int i=0; i<n; i++){
        int b = nsr[i]-nsl[i]-1;
        int area = b*a[i];
        
        // updating maximum area
        if(area>maxArea){
            maxArea = area;
        }
    }
    System.out.println(maxArea);
    
    
    // Stack<Integer> st = new Stack<>();
    // st.push(-1);
    // int max = 0;
    // for(int i=0; i<n; i++){
    //     int val = i == a.length ? 0 : a[i];
    //     while(st.size()>0 && a[st.peek()]>val){
    //         int idx = st.pop();
    //         max = Math.max(max, a[idx]*(i-st.peek()-1));
    //     }
    //     st.push(i);
    // }
    // System.out.println(max);
 }
}