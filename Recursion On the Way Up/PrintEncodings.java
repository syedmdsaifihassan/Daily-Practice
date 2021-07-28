/*
Print Encodings
Easy

1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Input Format
A string str

Output Format
Permutations of str in order hinted by Sample output

Constraints
0 <= str.length <= 10

Sample Input
655196

Sample Output
feeaif
feesf

 */

import java.io.*;
import java.util.*;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        printEncodings(str, "");
    }
    
    static String[] code = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void printEncodings(String str, String ans) {
        
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        if(str.charAt(0)=='0'){
            return;
        }
        
        String s1 = str.substring(0,1);
        String ros1 = str.substring(1);
        printEncodings(ros1, ans + (char)(Integer.parseInt(s1)-1+'a'));
        
        if(str.length()>=2){
            String s2 = str.substring(0,2);
            String ros2 = str.substring(2);
            if(Integer.parseInt(s2)<=26){
                printEncodings(ros2, ans + (char)(Integer.parseInt(s2)-1+'a'));
            }
        }
        
    }

}