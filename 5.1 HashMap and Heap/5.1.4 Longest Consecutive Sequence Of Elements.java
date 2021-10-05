/*
Longest Consecutive Sequence Of Elements
Hard
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.

Input Format
A number n
n1
n2
.. n number of elements

Output Format
Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15

Sample Input
17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11

Sample Output
5
6
7
8
9
10
11
12
13


Asked in Companies
Microsoft       5
Google      6
Amazon      6
Uber        5
Facebook        2
Apple       6
Bloomberg       5
Paypal      2
Spotify     2

*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0; i<n; i++){
        a[i] = sc.nextInt();
    }
    
    HashMap<Integer, Boolean> map = new HashMap<>();
    // 1. Consider all elements are valid starting points of the sequence that's why all is true.
    for(int i=0; i<n; i++){
        map.put(a[i], true);
    }
    
    // 2. Discard all invalid points
    for(int i=0; i<map.size(); i++){
        if(map.containsKey(a[i]-1) == true){
            map.put(a[i], false);
        }
    }
    
    // 3. Find the starting point of maximum length of consecutive elements
    int startPt = 0;
    int maxLen = 0;
    
    for(int i=0; i<n; i++){
        if(map.get(a[i])==true){
            int curElem = a[i];
            int curLen = 1;
            while(map.containsKey(curElem+1)==true){
                curElem++;
                curLen++;
            }
            if(curLen>maxLen){
                startPt = a[i];
                maxLen = curLen;
            }
        }
    }
    
    for(int i=0; i<maxLen; i++){
        System.out.println(startPt+i);
    }
    
 }

}