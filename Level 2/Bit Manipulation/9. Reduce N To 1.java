/*
Reduce N To 1
Easy

1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.

Constraints
1 <= N <= 2147483647

Sample Input
8
Sample Output
3

*/

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n) {
        //write your code here
        if(n==3){
            return 2;
        }
        long m = n;
        int count = 0;
        while(m != 1){
            if(m%4 == 1){
                m--;
                count++;
            }else if(m%4 == 3){
                m++;
                count++;
            }else if(m%2 == 0){
                m = m/2;
                count++;
            }
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}