/*
Get Stair Paths
Easy

1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
A number n

Output Format
Contents of the arraylist containing paths as shown in sample output

Constraints
0 <= n <= 10

Sample Input
3

Sample Output
[111, 12, 21, 3]

*/

import java.io.*;
import java.util.*;

public class GetStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        if(n==0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        if(n<0){
            ArrayList<String> bans = new ArrayList<>();
            return bans;
        }
        
        ArrayList<String> rr1 = getStairPaths(n-1);
        ArrayList<String> rr2 = getStairPaths(n-2);
        ArrayList<String> rr3 = getStairPaths(n-3);
        
        ArrayList<String> mr = new ArrayList<>();
        for(int i=0; i<rr1.size(); i++){
            mr.add("1"+rr1.get(i));
        }
        for(int i=0; i<rr2.size(); i++){
            mr.add("2"+rr2.get(i));
        }
        for(int i=0; i<rr3.size(); i++){
            mr.add("3"+rr3.get(i));
        }
        
        return mr;
    }

}