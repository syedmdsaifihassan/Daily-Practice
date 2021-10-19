/*
HackerRank Java Skill Test
Multi Sum

if given input is Integer array, return its sum. 
if given input is String array, concatenate the string string and return the answer

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MultiSum {
    
    public static boolean isNumeric(String string) {
        int intValue;
    		
        // System.out.println(String.format("Parsing string: \"%s\"", string));
    		
        if(string == null || string.equals("")) {
            // System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            // System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split(" ");
        
        if(isNumeric(strArr[0])){
            System.out.println(integerSum(strArr));
        }else{
            System.out.println(stringConcat(strArr));
        }
        
    }
    
    public static Integer integerSum(String[] strArr){
        
        int sum = 0;
        for(int i=0; i<strArr.length; i++){
            sum += Integer.parseInt(strArr[i]);
        }
        return sum;
    }
    
    public static String stringConcat(String[] strArr){

        String ans = "";
        for(int i=0; i<strArr.length; i++){
            ans += strArr[i];
        }
        return ans;
    }
}