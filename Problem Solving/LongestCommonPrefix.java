/*
14. Longest Common Prefix
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

*/

class Solution {
    public String longestCommonPrefix(String[] arr) {
        
        String ans = "";
        if(arr.length>0){
            Arrays.sort(arr);
            char[] a = arr[0].toCharArray();
            char[] b = arr[arr.length-1].toCharArray();

            for(int i=0; i<a.length; i++){
                if(b.length > 0 && a[i]==b[i]){
                    ans += b[i];
                }else{
                    return ans;
                }
            }
            return ans;
        }else{
            return ans;
        }
        
    }
}