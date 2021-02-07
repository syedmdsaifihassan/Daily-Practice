//LET'S REVIEW
/*
Objective
Today we will expand our knowledge of strings, combining it with what we have already learned about loops.

Task
Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line (see the Sample below for more detail).

Note: 0 is considered to be an even index.

Example
s=adbecf
Print abc def

Input Format

The first line contains an integer, T (the number of test cases).
Each line i of the T subsequent lines contain a string, S.

Constraints
1<=T<=10
2<=length of S<=10000

Output Format

For each String Sj (where 0<=j<=T-1), print Sj's even-indexed characters, followed by a space, followed by Sj's odd-indexed characters.

Sample Input

2
Hacker
Rank
Sample Output

Hce akr
Rn ak
Explanation

Test Case 0: S="Hacker"
S[0]="H"
S[1]="a"
S[2]="c"
S[3]="k"
S[4]="e"
S[5]="r"


The even indices are 0, 2, and 4, and the odd indices are 1, 3, and 5. We then print a single line of 2 space-separated strings; the first string contains the ordered characters from S's even indices (Hce), and the second string contains the ordered characters from S's odd indices (akr).

Test Case 1: S="Rank"
S[0]="R"
S[1]="a"
S[2]="n"
S[3]="k"


The even indices are 0 and 2, and the odd indices are 1 and 3. We then print a single line of 2 space-separated strings; the first string contains the ordered characters from S's even indices (Rn), and the second string contains the ordered characters from S's odd indices (ak).
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t>0){
        String s=scanner.next();
        
        String ans1="", ans2="";
        int i=0;
        int k=i+1;
        if(s.length()%2==0){
            for(i=0;i<s.length()-1;i+=2){
            ans1+=s.charAt(i);
            if(k<s.length()){
                ans2+=s.charAt(k);
                k+=2;
            }
            
        }
        }
        else{
            for(i=0;i<s.length();i+=2){
            ans1+=s.charAt(i);
            if(k<s.length()){
                ans2+=s.charAt(k);
                k+=2;
            }
            
        }
        }

        System.out.println(ans1+" "+ans2);
        t-=1;
        }
    }
}
