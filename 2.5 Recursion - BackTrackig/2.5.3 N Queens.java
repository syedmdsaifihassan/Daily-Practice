/*
N Queens
Easy

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
A number n

Output Format
Safe configurations of queens as suggested in sample output

Constraints
1 <= n <= 10

Sample Input
4

Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

Asked in Companies
Microsoft   2
Arcesium    1
Google  2
Amazon  6
eBay    2
ByteDance   4
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] chess = new boolean[n][n];
        
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(boolean[][] chess, String asf, int row) {
        if(row == chess.length){
            System.out.println(asf + ".");
            return;
        }   
        
        for(int col=0; col<chess.length; col++){
            if(isItSafe(chess, row, col)==true){
                chess[row][col] = true; // place the queen
                printNQueens(chess, asf+row+"-"+col+", ", row+1);
                chess[row][col] = false; // unplace the queen
            }
            
        }
    }
    
    public static boolean isItSafe(boolean[][] chess, int row, int col) {
        
        // check in col
        int i = row-1;
        while(i>=0){
            if(chess[i][col]==true){
                return false;
            }
            i--;
        }
        
        // check in diagonal 1
        i = row-1;
        int j=col+1;
        while(i>=0 && j<=chess.length-1){
            if(chess[i][j]==true){
                return false;
            }
            i--;
            j++;
        }
        
        // check in diagonal 2
        i = row-1;
        j = col-1;
        while(i>=0 && j>=0){
            if(chess[i][j]==true){
                return false;
            }
            i--;
            j--;
        }
        
        return true;
    }
}