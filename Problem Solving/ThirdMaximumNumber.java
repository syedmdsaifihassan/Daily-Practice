/*
414. Third Maximum Number

Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

*/

class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n-1];
        int c = 1, res = 0;
        
        for(int i=n-1; i>=0; i--){
            if(nums[i]!=max){
                max = nums[i];
                c++;
            }
            if(c==3){
                res = nums[i];
                break;
            }else if(c<3){
                res = nums[n-1];
            }
        }
        return res;
    }
}