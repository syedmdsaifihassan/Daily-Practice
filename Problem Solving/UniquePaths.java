/*
62. Unique Paths
Medium

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3

Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Example 3:
Input: m = 7, n = 3
Output: 28

Example 4:
Input: m = 3, n = 3
Output: 6

Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10^9.

*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        getMazePaths(dp,0,0,m-1,n-1);
        return dp[0][0];
    }
    
    public int getMazePaths(int[][] dp, int sr, int sc, int dr, int dc){
        
        if(sr>dr || sc>dc){
            return 0;
        }
        if(sr==dr && sc==dc){
            dp[sr][sc] = 1;
            return 1;
        }
        
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        
        int v = getMazePaths(dp, sr+1, sc, dr, dc);
        int h = getMazePaths(dp, sr, sc+1, dr, dc);
        
        dp[sr][sc]=v+h;
        return dp[sr][sc];
    }
}