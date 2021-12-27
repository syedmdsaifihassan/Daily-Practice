/*
Largest Number formed from an Array 
Medium Accuracy: 50.0% Submissions: 24056 Points: 4
Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.

Example 1:
Input: 
N = 5
Arr[] = {3, 30, 34, 5, 9}
Output: 9534330
Explanation: Given numbers are {3, 30, 34,
5, 9}, the arrangement 9534330 gives the
largest value.

Example 2:
Input: 
N = 4
Arr[] = {54, 546, 548, 60}
Output: 6054854654
Explanation: Given numbers are {54, 546,
548, 60}, the arrangement 6054854654 
gives the largest value.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function printLargest() which takes the array of strings arr[] as parameter and returns a string denoting the answer.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10^5
0 ≤ Arr[i] ≤ 10^18
Sum of all the elements of the array is greater than 0.

*/

class Solution {
    String printLargest(String[] arr) {
        // code here
        Arrays.sort(arr,(s1, s2) -> {
              String num1 = s1 + s2;
              String num2 = s2 + s1;
              return num2.compareTo(num1);
        });
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}