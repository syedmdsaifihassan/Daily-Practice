/*
1460. Make Two Arrays Equal by Reversing Sub-arrays

Given two integer arrays of equal length target and arr.

In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.

Return True if you can make arr equal to target, or False otherwise.

Example 1:
Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.

Example 2:
Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.

Example 3:
Input: target = [1,12], arr = [12,1]
Output: true

Example 4:
Input: target = [3,7,9], arr = [3,7,11]
Output: false
Explanation: arr doesn't have value 9 and it can never be converted to target.

Example 5:
Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
Output: true

Constraints:
target.length == arr.length
1 <= target.length <= 1000
1 <= target[i] <= 1000
1 <= arr[i] <= 1000

*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        boolean result  = false;
        int n=target.length;
        int c=0;
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp=0;
                if(target[i]>target[j]) {
                    temp=target[i];
                    target[i]=target[j];
                    target[j]=temp;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp=0;
                if(arr[i]>arr[j]) {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(target[i]==arr[i]) {
                c++;
            }
        }
        
        if(c==n) {
            result = true;
        }
        
        return result;
        
    }
}