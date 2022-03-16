/*
Swapping Chefs Way 
Problem Code: SWAPCW
Chef is working on his swap-based sorting algorithm for strings.

Given a string S of length N, he wants to know whether he can sort the string using his algorithm.

According to the algorithm, one can perform the following operation on string S any number of times:

Choose some index i (1≤i≤N) and swap the ith character from the front and the ith character from the back.
More formally, choose an index i and swap Si and S(N+1−i).
For example, 𝚍⎯⎯𝚌𝚋𝚊⎯⎯ can be converted to 𝚊⎯⎯𝚌𝚋𝚍⎯⎯ using one operation where i=1.

Help Chef find if it is possible to sort the string using any (possibly zero) number of operations.

Input Format
The first line of the input contains a single integer T, denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains N, the length of the string.
The second line contains a string S of length N consisting of lowercase letters of the Latin alphabet.

Output Format
For each test case, print 𝚈𝙴𝚂 if it is possible to sort the string by performing any number of operations. Otherwise, print 𝙽𝙾.

You may print each character of the string in uppercase or lowercase (for example, the strings 𝚈𝚎𝚂, 𝚢𝙴𝚜, 𝚢𝚎𝚜 and 𝚈𝙴𝚂 will all be treated as identical).

Constraints
1≤T≤100
1≤N≤10^3

Sum of N over all test cases does not exceed 2⋅103.
S consists of lowercase Latin alphabets only.

Sample Input 1 
3
4
dbca
3
ccc
3
bza

Sample Output 1 
YES
YES
NO

Explanation
Test case 1: Chef can sort the string using 1 operation.

Choose i=1 and swap S1=𝚍 and S4=𝚊. This way, the string becomes 𝚊𝚋𝚌𝚍.
Hence, the string is sorted.

Test case 2: Chef needs 0 operations to sort this string as it is already sorted.

Test case 3: It can be proven that the given string cannot be sorted using any number of operations.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t > 0){
		    int n = scn.nextInt();
		    String str = scn.next();
		    System.out.println(solve(str,n)==true?"YES":"NO");
		    t--;
		}
    }
    
    public static boolean solve(String str, int n){
	    int[] arr = new int[n];
	    int[] ans = new int[n];
	    for(int i=0;i<n;i++){
	        arr[i] = str.charAt(i)-'0';
	        ans[i] = str.charAt(i)-'0';
	    }
	    int left=0,right=arr.length-1;
	     while(left<right){
	        if(arr[left]>arr[right]){
    	        int temp=arr[left];
    	        arr[left]=arr[right];
    	        arr[right]=temp;
	        }
	        left++;
	        right--;
	    }
	    
	    Arrays.sort(ans);
	    for(int i=0;i<n;i++){
	       if(arr[i] != ans[i]){
	           return false;
	       }
	    }
	    return true;
	}
}