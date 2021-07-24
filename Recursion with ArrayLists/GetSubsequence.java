/*
Get Subsequence
Easy

1. You are given a string str.
2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
Use sample input and output to take idea about subsequences.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
A string str

Output Format
Contents of the arraylist containing subsequences as shown in sample output

Constraints
0 <= str.length <= 20

Sample Input
abc

Sample Output
[, c, b, bc, a, ac, ab, abc]

*/

import java.io.*;
import java.util.*;

public class GetSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0) {
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        
        char ch = str.charAt(0);    
        String ros = str.substring(1);
        ArrayList<String> rr = gss(ros);
        
        ArrayList<String> mr = new ArrayList<>();
        for(int i=0; i<rr.size(); i++) {
            mr.add(rr.get(i));
            
        }
        for(int i=0; i<rr.size(); i++) {
            mr.add(ch+rr.get(i));
            
        }
        
        return mr;
    }

}