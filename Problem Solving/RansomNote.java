/*
383. Ransom Note
Easy

Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] cr = ransomNote.toCharArray();
        char[] cm = magazine.toCharArray();
        
        Arrays.sort(cr);
        Arrays.sort(cm);
        
        int n = cr.length;
        int mlen = cm.length;
        int i=0, j=0;
        
        if(n<=mlen){
            while(i<n && j<mlen){
                if(cr[i]==cm[j]){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            if(i==n){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}