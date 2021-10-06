/*
K Largest Elements
Medium
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. You are required to find and print the k largest elements of array in increasing order.

Output Format
Print the k largest elements of array in increasing order in separate lines.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 100
0 < k <= n

Sample Input
13
12
62
22
15
37
99
11
37
98
67
31
84
99
4

Sample Output
84
98
99
99


Asked in Companies
Microsoft       2
Google      4
Amazon      11
Facebook        52
Apple       3
ByteDance       5
Spotify     2

*/

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for(int i=0; i<k; i++){
          pq.add(arr[i]);
      }
      
      for(int i=k; i<n; i++){
          if(arr[i]>pq.peek()){
              pq.remove();
              pq.add(arr[i]);
          }
      }
      
      while(pq.size()!=0){
          System.out.println(pq.remove());
      }
    }

}