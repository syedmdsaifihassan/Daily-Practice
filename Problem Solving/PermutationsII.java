/*
47. Permutations II
Medium

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        
        recur(nums, ans, temp, check);
        
        return ans;
    }
    
    public void recur(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] check){
        if(temp.size()==nums.length){
            if(ans.contains(temp)==false){
                ans.add(new ArrayList<>(temp));
            }
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