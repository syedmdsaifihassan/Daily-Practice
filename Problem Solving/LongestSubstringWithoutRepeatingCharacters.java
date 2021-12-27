/*
3. Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest substring without repeating characters. 

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() ==0 ) return 0;
        int p1 = 0, p2 = 1;
        char ch[] = s.toCharArray();
        int min = 1;
        Set<Character> set = new HashSet<>();
        set.add(ch[p1]);
        while(p1 < ch.length && p2 < ch.length) {
            if(set.contains(ch[p2])) {
                set.remove(ch[p1]);
                    p1++;
            } else {
                set.add(ch[p2]);
                p2++;
            }
            min = Math.max(min, p2 - p1);
        }
        return min;
    }
}