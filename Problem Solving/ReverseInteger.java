/*
7. Reverse Integer
Medium

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0

Constraints:
-2^31 <= x <= 2^31 - 1

*/

class Solution {
    public int reverse(int x) {
        
        int ans = 0;
        while(x!=0){
            int rev = ans*10 + (x%10);

            // reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1]
            if((rev-x%10)/10 != ans){
                return 0;
            }
            
            x = x/10;
            ans = rev;
        }
        
        return ans;
    }
}