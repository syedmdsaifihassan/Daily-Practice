/*
905. Sort Array By Parity

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Note:
1 <= A.length <= 5000
0 <= A[i] <= 5000

*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int n = A.length;
        int c = 0;
        int d = n-1;
        
        for(int i=0; i<n; i++) {
            if(A[i]%2 == 0) {
                B[c]=A[i];
                c++;
            } else {
                B[d]=A[i];
                d--;
            }
        }
        return B;
    }
}