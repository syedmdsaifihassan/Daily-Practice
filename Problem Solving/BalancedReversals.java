/*

Balanced Reversals 
Problem Code: BALREV

Chef is given a binary string A of length N. He can perform the following operation on A any number of times:

Choose L and R (1≤L≤R≤N), such that, in the substring A[L,R], the number of 1s is equal to the number of 0s and reverse the substring A[L,R].
Find the lexicographically smallest string that Chef can obtain after performing the above operation any (possibly zero) number of times on A.

String X is lexicographically smaller than string Y, if either of the following satisfies:

X is a prefix of Y and X≠Y.
There exists an index i such that Xi<Yi and Xj=Yj,∀j such that 1≤j<i.

Input Format
First line will contain T, the number of test cases. Then the test cases follow. Each test case contains two lines.
The first line contains the integer N, the length of the binary string.
The second line contains the binary string A.

Output Format
For each test case, print the lexicographically smallest binary string that can be obtained after performing the operation any (possibly zero) number of times.

Constraints
1≤T≤100
1≤N≤10^5
Sum of N over all test cases does not exceed 2⋅105.

Sample Input 1 
2
5
01100
4
0000

Sample Output 1 
00011
0000

Explanation
Test Case 1: Chef can choose L=2 and R=5. The chosen substring, A[2,5]=1100. On reversing this, we get 0011. Thus, the final string is A=00011. Note that this is the lexicographically smallest string possible.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t>0) {
		    int n = scn.nextInt();
		    String str=scn.next();
		    
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(str.charAt(i)+"");
		    }
		    
		    moveZero(arr);
		    for(int i=0;i<n;i++){
		        System.out.print(arr[i]);
		    }
		    System.out.println(""); 
		    t--;
		}
	}
	public static void moveZero(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[temp++] = nums[i];
            }
        }
        while(temp < nums.length ) {
            nums[temp++] = 0;
        }
        int left=0,right=nums.length-1;
        while(left<right){
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
