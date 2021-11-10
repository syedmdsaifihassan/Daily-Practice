/*
Pepcoder And Bits
Easy

1. Pepcoder is feeling confident after solving many problems on Bit Manipulation.
2. So, his teacher ask him to find out the count of positive integers strictly less than N, having same 
     number of set bits as that of N.
3. Let us see that if pepcoder can solve it or not.

Constraints
1 <= N <= 10^12

Sample Input
1024
Sample Output
10

*/

import java.io.*;
import java.util.*;

public class Main {
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n) {
        int c = csb(n);
        
        long ans = 0;
        
        for(int i=62; i>=0; i--){
            // check if the ith bit is on or off
            long mask = (long)Math.pow(2,i);
            if((n&mask) != 0 && c>0){
                ans += ncr(i,c);
                c--;
            }
        }
        
        return ans;
    }
    
    // Kernighans Algorithm (Count Set Bits)
    public static int csb(long n){
        int res = 0;
        
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        System.out.println(solution(n));
    }
	
	
}