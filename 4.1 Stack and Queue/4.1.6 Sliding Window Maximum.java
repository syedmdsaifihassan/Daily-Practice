/*
Sliding Window Maximum
Hard
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]

Constraints
0 <= n < 100000
-10^9 <= a[i] <= 10^9
0 < k < n

Asked in Companies
Microsoft       4
Adobe       2
Google      3
Amazon      16
Uber        4
Oracle      2
Apple       2
Bloomberg       2
Citadel     2
Roblox      3
Databricks      5

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
    int k = Integer.parseInt(br.readLine());

    // code
    
    Deque<Integer> dq = new ArrayDeque<>();
    
    for(int i=0; i<a.length; i++){
        while(dq.size()>0 && a[dq.getLast()] < a[i]){
            dq.removeLast();
        }
        dq.addLast(i);
        
        if(dq.peek() <= i-k){
            dq.removeFirst();
        }
        
        if(i>=k-1){
            System.out.println(a[dq.peek()]);
        }
    }
    
 }
}