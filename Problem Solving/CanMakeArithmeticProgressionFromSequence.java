/*
1502. Can Make Arithmetic Progression From Sequence

Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.

Example 1:
Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.

Example 2:
Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.


Constraints:
2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6

*/

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int d, itr=0;
        boolean result=false;
        
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
        
        d=arr[1]-arr[0];
        for(int i=0; i<n-1; i++) {
            if((arr[i]+d)==arr[i+1]) {
                itr++;
            }
        }
        if(itr==(n-1)) {
            result=true;
        }
        
        return result;
    }
}