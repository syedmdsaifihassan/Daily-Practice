/*
980. Unique Paths III
Hard

You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

*/

class Solution {
    int zero = 0;
    int ans = 0;
    public int uniquePathsIII(int[][] grid) {
        int srcI=0, srcJ=0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    srcI=i;
                    srcJ=j;
                }
                if(grid[i][j]==0){
                    zero += 1;
                }
            }
        }
        travelGrid(grid, srcI, srcJ, -1, zero);
        return ans;
    }
    
    public void travelGrid(int[][]grid, int row, int col, int c, int zero){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==-1){
            return;
        }
        
        if(grid[row][col] == 2){
            if(c==zero){
                ans+=1;
            }
            return;
        }
        
        grid[row][col] = -1;
        travelGrid(grid, row-1, col, c+1, zero);   //up
        travelGrid(grid, row+1, col, c+1, zero);   //down
        travelGrid(grid, row, col-1, c+1, zero);   //left
        travelGrid(grid, row, col+1, c+1, zero);   //right
        grid[row][col] = 0;
    }
}