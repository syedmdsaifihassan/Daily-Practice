/*
Count Encodings

1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.

     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic 
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
     print 0.

Input Format
A string str

Output Format
count of encodings

Constraints
0 < str.length <= 10

Sample Input
123
Sample Output
3

Asked in Companies
Amazon      1
Goldman Sachs       1
LinkedIn        1
Morgan Stanley      1
Facebook        1
MakeMyTrip      1

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        System.out.println(ce(str, 0));
    }
    
    public static int ce(String str, int idx){
        if(idx == str.length()){
            return 1;
        }
        if(idx > str.length()){
            return 0;
        }
        
        if(str.charAt(idx) == '0'){
            return 0;
        }
        
        int f1 = ce(str, idx+1);
        int f2 = 0;
        
        // if(idx<=str.length()-2 && Integer.parseInt(str.substring(idx, idx+2))<=26){
        //     f2 = ce(str, idx+2);
        // }
        
        if(idx+1<str.length()){
            int chi = str.charAt(idx)-'0';
            int chip1 = str.charAt(idx+1)-'0';
            if(chi*10 + chip1 <= 26){
                f2 = ce(str, idx+2);
            }
        }
        
        return f1+f2;
    }
}