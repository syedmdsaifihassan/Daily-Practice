/*
Get Common Elements - 2
Easy
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to find the intersection of a1 and a2. To get an idea check the example below:
 
if a1 -> 1 1 2 2 2 3 5
and a2 -> 1 1 1 2 2 4 5
intersection is -> 1 1 2 2 5

Note -> Don't assume the arrays to be sorted.

Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated

Output Format
All relevant elements of intersection in separate lines
The elements of intersection should be printed in order of their occurence in a2.

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Time complexity should be O(n)

Sample Input
7
1
1
2
2
2
3
5
7
1
1
1
2
2
4
5

Sample Output
1
1
2
2
5

Asked in Companies
MAQ Software        1

*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    
    // Array 1 size and elements
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++){
        arr1[i] = sc.nextInt();
    }
    
    // Array 2 size and elements
    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++){
        arr2[i] = sc.nextInt();
    }
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<n1; i++){
        map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
    }
    
    for(int i=0; i<n2; i++){
        if(map.containsKey(arr2[i])==true){
            System.out.println(arr2[i]);
            map.put(arr2[i], map.get(arr2[i])-1);
            if(map.get(arr2[i])==0){
                map.remove(arr2[i]);
            }
        }
    }
 }

}