/*
Balanced Brackets

1. You are given a string exp representing an expression.
2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false

Input Format
A string str

Output Format
true or false

Constraints
0 <= str.length <= 100

Sample Input
[(a + b) + {(c + d) * (e / f)}]

Sample Output
true

*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{'||ch=='['){
                st.push(ch);
            }else if(ch==')' || ch=='}'||ch==']'){
                if(st.size()==0){
                    System.out.println(false);  //more closing bracks
                    return;
                }
                if(ch==')'){
                    if(st.peek()!='('){
                        System.out.println(false);  //mismatch
                        return;
                    }
                }else if(ch=='}'){
                    if(st.peek()!='{'){
                        System.out.println(false);  //mismatch
                        return;
                    }
                }else if(ch==']'){
                    if(st.peek()!='['){
                        System.out.println(false);  //mismatch
                        return;
                    }
                }
                st.pop();
            }
        }
        
        if(st.size()!=0){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }

}