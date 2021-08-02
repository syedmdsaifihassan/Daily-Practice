/*
58. Length of Last Word
Easy

Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5

Example 2:
Input: s = " "
Output: 0

Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.

*/

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int c = 0;
        for(int i=0; i<s.length(); i++){
            c++;
            if(s.charAt(i)==' '){
                c = 0;
            }
        }
        return c;
    }
}