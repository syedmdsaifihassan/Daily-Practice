/*
Gift Shop and Coupon
Problem Code: GFTSHP

Chef wants to impress Chefina by giving her the maximum number of gifts possible.

Chef is in a gift shop having N items where the cost of the ith item is equal to Ai. Chef has K amount of money and a 50% off discount coupon that he can use for at most one of the items he buys.

If the cost of an item is equal to X, then, after applying the coupon on that item, Chef only has to pay ⌈X2⌉ (rounded up to the nearest integer) amount for that item.

Help Chef find the maximum number of items he can buy with K amount of money and a 50% discount coupon given that he can use the coupon on at most one item.

Input Format
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers N and K.
The next line contains N space-separated integers, where the ith integer Ai denotes the cost of the ith item.

Output Format
For each test case, print a single line containing one integer ― the maximum number of items Chef can buy.

Constraints
1≤T≤10^3
1≤N≤10^5
1≤Ai≤10^9
0≤K≤10^9
Sum of N over all test cases does not exceed 2⋅105.

Sample Input 1 
3
1 4
5
3 15
4 4 5
3 10
6 7 4

Sample Output 1 
1
3
2

Explanation
Test case 1: After applying the discount, Chef can buy the only available item at ⌈52⌉=3.

Test case 2: Chef can buy all three items even without using the coupon.

Test case 3: After applying coupon on the third item, Chef can buy the second and the third item at 7+⌈42⌉= 7+2=9.
It is not possible for Chef to buy more than two items.

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
	
	    Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int j=0;j<T;j++) {
		    int N = scanner.nextInt();
		    int K = scanner.nextInt();
		    int[] arr=new int[N];
		    
            for(int i=0;i<N;i++){
                arr[i]=scanner.nextInt();
            }
            Arrays.sort(arr);
            int itr = 0;
            for(int i=0;i<N;i++){
                if(K-arr[i]<0){
                    
                    if(K>=(arr[i]/2+(arr[i]%2>0?1:0)))
                        itr++;
                    break;
                }
                itr++;
                K -= arr[i];
            }
            System.out.println(itr);
		}
	}
	
}