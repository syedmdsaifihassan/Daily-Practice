/*
Highest Frequency Character
Easy
1. You are given a string str.
2. You are required to find the character with maximum frequency.

Input Format
A string str

Output Format
The character with highest frequency

Constraints
0 < str.length() <= 100
There will be a single character with highest frequency

Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc

Sample Output
q

Asked in Companies
Amazon      6

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0;
        char maxfChar = 'a';
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)==true){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
            //updating maximum frequency and maximum frequency character
            if(map.get(ch)>maxfreq){
                maxfreq = map.get(ch);
                maxfChar = ch;
            }
        }
        
        System.out.println(maxfChar);
    }

}