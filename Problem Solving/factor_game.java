/*
Factor Game
Problem Description

Write a program to input T numbers(N) from user and print all the factors of the given numbers.



Problem Constraints
1 <= T <= 1000

1 <= N <= 100000000



Input Format
First line is T which means number of test cases.

Each next T lines contain an integer N.



Output Format
T lines each containing space separated integers in sorted form representing all the factors of the input integer.



Example Input
Input 1:

2
6
10
Input 2:

2
7
18


Example Output
Output 1:

1 2 3 6
1 2 5 10
Output 2:

1 7
1 2 3 6 9 18


Example Explanation
Explanation 1:

6 is divisible by 1,2,3,6.
10 is divisible by 1,2,5,10.
Explanation 2:

7 is divisible by only 1,7.
18 is divisible by 1,2,3,6,9,18.
*/

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
		
        
        while(T>0){
            ArrayList<Integer> arr=new ArrayList<Integer>();
            int N = sc.nextInt();
            for(int i=1;i*i<=N;i++){
                if(N%i==0){
                    arr.add(i);
                    if(i!=N/i){
                        arr.add(N/i);
                    }
                    
                    
                    
                }
                
            }
            Collections.sort(arr);
            int[] ar=new int[arr.size()];
            for(int i=0;i<ar.length;i++) ar[i]=arr.get(i);
            for(int i=0;i<ar.length;i++) System.out.print(ar[i]+" ");
            System.out.println();
            T--;
        }
        
    }
}