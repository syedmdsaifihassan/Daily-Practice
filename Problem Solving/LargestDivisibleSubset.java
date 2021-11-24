/*
368. Largest Divisible Subset
Medium

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

Example 1:
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.

Example 2:
Input: nums = [1,2,4,8]
Output: [1,2,4,8]

Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.

*/

public class Solution {
    Map<Integer,List<Integer>> mem = new HashMap<>();
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0);
    }
    
    public List<Integer> helper(int[] nums, int i) {
        if(mem.containsKey(i))  return mem.get(i);
        
        List<Integer> maxLenLst = new ArrayList<>();
        
        int div;
        if(i==0){
            div = 1;
        }else{
            div = nums[i-1];
        }
        
        for(int k=i; k<nums.length; k++) {
            if(nums[k] % div == 0) {
                List<Integer> lst = new ArrayList<>(helper(nums, k+1)); 
                lst.add(nums[k]);
                if(lst.size() > maxLenLst.size())   maxLenLst = lst;
            }
        }
        mem.put(i, maxLenLst);
        return maxLenLst;
    }
}