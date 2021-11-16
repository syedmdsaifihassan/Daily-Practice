/*
46. Permutations
Medium

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        
        recur(nums, ans, temp, check);
        
        return ans;
    }
    
    public void recur(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] check){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(check[i]==false){
                check[i] = true;
                temp.add(nums[i]);
                recur(nums, ans, temp, check);
                temp.remove(temp.size()-1);
                check[i] = false;
            }
        }
    }
}