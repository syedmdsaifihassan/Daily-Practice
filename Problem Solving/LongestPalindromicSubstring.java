/*
5. Longest Palindromic Substring
Medium

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb" 

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.

*/

/* Solution 1 */
class Solution {
    public String longestPalindrome(String s) {
        int ans = Integer.MIN_VALUE;
        String res = "";
        for(int i=1; i<s.length(); i++){
            int p1 = i-1;
            int p2 = i+1;
            while((p1>=0 && p2<s.length()) && s.charAt(p1) == s.charAt(p2)){
                if(ans < (p2-p1)+1){
                    ans = (p2-p1)+1;
                    res = s.substring(p1, p2+1);
                }
                p1--;
                p2++;
            }
            p1=i-1;
            p2=i;
            while((p1>=0 && p2<s.length()) && s.charAt(p1) == s.charAt(p2)){
                if(ans < (p2-p1)+1){
                    ans = (p2-p1)+1;
                    res = s.substring(p1, p2+1);
                }
                p1--;
                p2++;
            }
        }
        if(res.length()==0) return s.charAt(0)+"";
        return res;
    }
}

/* Solution 2 */
class Solution {
    public String longestPalindrome(String s) {
        int ans = Integer.MIN_VALUE;
        String res = "";
        for(int i=0; i<s.length()-1; i++){
            int p1 = i-1;
            int p2 = i+1;
            while((p1>=0 && p2<s.length()) && s.charAt(p1) == s.charAt(p2)){
                if(ans < (p2-p1)+1){
                    ans = (p2-p1)+1;
                    res = s.substring(p1, p2+1);
                }
                p1--;
                p2++;
            }
            p1=i;
            p2=i+1;
            while((p1>=0 && p2<s.length()) && s.charAt(p1) == s.charAt(p2)){
                if(ans < (p2-p1)+1){
                    ans = (p2-p1)+1;
                    res = s.substring(p1, p2+1);
                }
                p1--;
                p2++;
            }
        }
        if(res.length()==0) return s.charAt(0)+"";
        return res;
    }
}