/*
130. Surrounded Regions
Medium

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.

*/

class Solution {
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        //top
        for(int j=0; j<board[0].length; j++){
            if(board[0][j]=='O'){
                dfs(board, 0, j);
            }
        }
        //bottom
        for(int j=0; j<board[0].length; j++){
            if(board[board.length-1][j]=='O'){
                dfs(board, board.length-1, j);
            }
        }
        //left
        for(int i=0; i<board.length; i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0);
            }
        }
        //right
        for(int i=0; i<board.length; i++){
            if(board[i][board[0].length-1]=='O'){
                dfs(board, i, board[0].length-1);
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='*'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void dfs(char[][] board, int row, int col){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!='O'){
            return;
        }
        
        board[row][col] = '*';
        dfs(board, row-1, col); //up
        dfs(board, row+1, col); //down
        dfs(board, row, col-1); //left
        dfs(board, row, col+1); //right
    }
}