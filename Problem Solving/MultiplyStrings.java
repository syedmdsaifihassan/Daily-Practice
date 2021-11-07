/*
43. Multiply Strings
Medium

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.

*/

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        if(num1.equals("1")){
            return num2;
        }
        if(num2.equals("1")){
            return num1;
        }
        
        int n = num1.length();
        int m = num2.length();
        
        int[] res = new int[m+n];
        
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                mul += res[i+j+1];
                res[i+j+1] = mul%10;
                res[i+j] += mul/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(res[0]!=0){
            sb.append(res[0]);
        }
        for(int i=1; i<res.length; i++){
            sb.append(res[i]);
        }
        
        return sb.toString();
    }
}