/*
345. Reverse Vowels of a String
Easy

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

*/

class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        String vowels = "aeiouAEIOU";
        int l = 0; 
        int r = n-1;
        
        while(l<r){
            String lstr = Character.toString(ch[l]);
            String rstr = Character.toString(ch[r]);
            
            boolean lstat = vowels.contains(lstr);

            boolean rstat = vowels.contains(rstr);
            
            if(lstat == true && rstat == true){
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
            if(lstat == false){
                l++;
            }
            if(rstat == false){
                r--;
            }
        }
        String result = new String(ch);
        return result;
    }
}